package kr.co.kbhealthcareproject.service;

import kr.co.kbhealthcareproject.dto.ActivityRequestDto;
import kr.co.kbhealthcareproject.entity.ActivityEntry;
import kr.co.kbhealthcareproject.entity.ActivityRecord;
import kr.co.kbhealthcareproject.entity.enums.OsType;
import kr.co.kbhealthcareproject.repository.ActivityRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


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
}
