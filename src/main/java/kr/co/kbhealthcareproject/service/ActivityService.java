package kr.co.kbhealthcareproject.service;

import kr.co.kbhealthcareproject.dto.request.ActivityRequestDto;
import kr.co.kbhealthcareproject.dto.response.DailyActivityResponseDto;
import kr.co.kbhealthcareproject.dto.response.MonthlyActivityResponseDto;
import kr.co.kbhealthcareproject.entity.ActivityEntry;
import kr.co.kbhealthcareproject.entity.ActivityRecord;
import kr.co.kbhealthcareproject.entity.Source;
import kr.co.kbhealthcareproject.entity.enums.OsType;
import kr.co.kbhealthcareproject.repository.ActivityRecordRepository;
import kr.co.kbhealthcareproject.repository.SourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private final SourceRepository sourceRepository;

    // ISO 8601 포맷 문자열을 처리하기 위한 데이터포맷
    private static final DateTimeFormatter ISO_WITHOUT_Z_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");


    @Transactional
    @Caching(evict = {
            @CacheEvict(value="dailyActivityData", allEntries = true, cacheManager = "cacheManager"),
            @CacheEvict(value="monthlyActivityData", allEntries = true, cacheManager = "cacheManager")
    })
    public void saveActivityData(ActivityRequestDto request) {

        //운영체제 구별
        OsType osType = determineOsType(request);

        // Source 객체 생성 및 설정
        Source source = Source.builder()
                .productName(request.getData().getSource().getProduct().getName())
                .vender(request.getData().getSource().getProduct().getVender())
                .type(request.getData().getSource().getType())
                .mode(request.getData().getSource().getMode())
                .name(request.getData().getSource().getName())
                .build();

        // Source 저장
        sourceRepository.save(source);

        //활동기록 객체 생성
        ActivityRecord record = ActivityRecord.builder()
                .recordKey(request.getRecordkey())
                .osType(osType)
                .memo(request.getData().getMemo())
                .source(source)
                .lastUpdate(request.getLastUpdate())
                .type(request.getType())
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
        // product name을 가져와서 비교
        String productName = request.getData().getSource().getProduct().getName();

        if ("iPhone".equalsIgnoreCase(productName)) {
            return OsType.IOS;
        } else if ("Android".equalsIgnoreCase(productName)) {
            return OsType.AOS;
        } else {
            // 예외 처리나 기본값 처리
            throw new IllegalArgumentException("Unknown product name: " + productName);
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


    // 일별 데이터 조회
    @Transactional(readOnly = true)
    @Cacheable(value = "dailyActivityData", key = "#recordKey", unless = "#result == null || #result.isEmpty()")
    public List<DailyActivityResponseDto> getDailyActivityData(String recordKey) {
        // 특정 recordKey에 맞는 ActivityRecord 조회
        List<ActivityRecord> records = recordRepository.findByRecordKey(recordKey);

        // 날짜 포맷 정의 (2024-11.15 형식)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM.dd");

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

                    // Distance 값을 소수점 4자리로 반올림
                    BigDecimal roundedDistance = new BigDecimal(totalDistance).setScale(4, RoundingMode.HALF_UP);

                    return new DailyActivityResponseDto(
                            activityDate.format(formatter),   // 날짜
                            totalSteps,     // 총 Steps
                            (int) totalCalories, // 총 Calories
                            roundedDistance,  // 총 Distance
                            recordKey       // RecordKey
                    );
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "monthlyActivityData", key = "#recordKey", unless = "#result == null || #result.isEmpty()")
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

                    // Distance 값을 소수점 4자리로 반올림
                    BigDecimal roundedDistance = new BigDecimal(totalDistance).setScale(4, RoundingMode.HALF_UP);

                    // 계산된 월별 데이터와 recordKey를 사용하여 MonthlyActivityResponseDto 객체 생성
                    return new MonthlyActivityResponseDto(
                            month.toString(),   // 날짜
                            totalSteps,     // 총 Steps
                            (int) totalCalories, // 총 Calories
                            roundedDistance,  // 총 Distance
                            recordKey       // RecordKey
                    );
                })
                .collect(Collectors.toList());
    }
}
