package kr.co.kbhealthcareproject.service;

import kr.co.kbhealthcareproject.dto.request.ActivityRequestDto;
import kr.co.kbhealthcareproject.dto.response.DailyActivityResponseDto;
import kr.co.kbhealthcareproject.dto.response.MonthlyActivityResponseDto;
import kr.co.kbhealthcareproject.entity.ActivityEntry;
import kr.co.kbhealthcareproject.entity.ActivityRecord;
import kr.co.kbhealthcareproject.entity.enums.OsType;
import kr.co.kbhealthcareproject.repository.ActivityRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRecordRepository recordRepository;

    // ISO 8601 포맷 문자열을 처리하기 위한 데이터포맷
    private static final DateTimeFormatter ISO_WITHOUT_Z_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");


    @Transactional
    public void saveActivityData(ActivityRequestDto request) {

        //운영체제 구별
        OsType osType = determineOsType(request);

        //활동기록 객체 생성
        ActivityRecord record = ActivityRecord.builder()
                .recordKey(request.getRecordkey())
                .osType(osType)
                .memo(request.getData().getMemo())
                .build();

        //활동기록 객체에 활동기록 엔티티 추가
        List<ActivityEntry> entries = request.getData().getEntries().stream()
                .map(entryDto -> ActivityEntry.builder()
                        .activityRecord(record)
                        .periodFrom(parseDate(entryDto.getPeriod().getFrom(), osType))
                        .periodTo(parseDate(entryDto.getPeriod().getTo(), osType))
                        .distanceValue(entryDto.getDistance().getValue())
                        .distanceUnit(entryDto.getDistance().getUnit())
                        .caloriesValue(entryDto.getCalories().getValue())
                        .caloriesUnit(entryDto.getCalories().getUnit())
                        .steps(Double.parseDouble(entryDto.getSteps().toString()))
                        .build())
                .toList();

        record.setEntries(entries);

        //활동기록 저장
        recordRepository.save(record);
    }


    private OsType determineOsType(ActivityRequestDto request) {
        String periodFrom = request.getData().getEntries().get(0).getPeriod().getFrom();

        if (isIso8601Date(periodFrom)) {
            return OsType.IOS;
        } else {
            return OsType.AOS;
        }
    }

    private LocalDateTime parseDate(String dateStr, OsType osType) {
        try {
            if (osType == OsType.IOS) {
                return OffsetDateTime.parse(dateStr, ISO_WITHOUT_Z_FORMATTER)
                        .atZoneSameInstant(ZoneOffset.UTC)
                        .toLocalDateTime();
            } else {
                return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format: " + dateStr);
        }
    }

    private boolean isIso8601Date(String dateStr) {
        try {
            OffsetDateTime.parse(dateStr, ISO_WITHOUT_Z_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // 일별 데이터 조회
    @Transactional(readOnly = true)
    public List<DailyActivityResponseDto> getDailyActivityData(String recordKey) {
        // 특정 recordKey에 맞는 ActivityRecord 조회
        List<ActivityRecord> records = recordRepository.findByRecordKey(recordKey);

        // 조회된 ActivityRecord에서 각 ActivityEntry를 날짜별로 그룹화하여 응답
        return records.stream()
                .flatMap(record -> record.getEntries().stream())
                .collect(Collectors.groupingBy(entry -> entry.getPeriodFrom().toLocalDate()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    LocalDate activityDate = entry.getKey();
                    List<ActivityEntry> entriesForDate = entry.getValue();

                    // 해당 날짜에 대한 Steps, Calories, Distance 합산
                    int totalSteps = entriesForDate.stream()
                            .mapToInt(entryForDate -> (int) entryForDate.getSteps())
                            .sum();

                    double totalCalories = entriesForDate.stream()
                            .mapToDouble(ActivityEntry::getCaloriesValue)
                            .sum();

                    double totalDistance = entriesForDate.stream()
                            .mapToDouble(ActivityEntry::getDistanceValue)
                            .sum();

                    return new DailyActivityResponseDto(
                            activityDate,   // 날짜
                            totalSteps,     // 총 Steps
                            (int) totalCalories, // 총 Calories
                            totalDistance,  // 총 Distance
                            recordKey       // RecordKey
                    );
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MonthlyActivityResponseDto> getMonthlyActivityData(String recordKey) {

        // recordKey에 해당하는 ActivityRecord 데이터를 조회
        List<ActivityRecord> records = recordRepository.findByRecordKey(recordKey);

        // ActivityRecord에서 각 ActivityEntry를 월별로 그룹화하여 응답
        return records.stream()
                .flatMap(record -> record.getEntries().stream())
                .collect(Collectors.groupingBy(entry -> YearMonth.from(entry.getPeriodFrom())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    YearMonth month = entry.getKey();
                    List<ActivityEntry> monthlyEntries = entry.getValue();

                    // 해당 월의 총 Steps 계산 (double 값이 있을 경우 int로 변환)
                    int totalSteps = monthlyEntries.stream()
                            .mapToInt(entryInfo -> (int) entryInfo.getSteps())
                            .sum();

                    // 해당 월의 총 Calories 계산
                    double totalCalories = monthlyEntries.stream()
                            .mapToDouble(ActivityEntry::getCaloriesValue)
                            .sum();

                    // 해당 월의 총 Distance 계산
                    double totalDistance = monthlyEntries.stream()
                            .mapToDouble(ActivityEntry::getDistanceValue)
                            .sum();

                    // 계산된 월별 데이터와 recordKey를 사용하여 MonthlyActivityResponseDto 객체 생성
                    return new MonthlyActivityResponseDto(
                            month.toString(),   // 날짜
                            totalSteps,     // 총 Steps
                            (int) totalCalories, // 총 Calories
                            totalDistance,  // 총 Distance
                            recordKey       // RecordKey
                    );
                })
                .collect(Collectors.toList());
    }
}
