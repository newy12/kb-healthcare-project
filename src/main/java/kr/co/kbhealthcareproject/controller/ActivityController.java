package kr.co.kbhealthcareproject.controller;

import kr.co.kbhealthcareproject.dto.request.ActivityRequestDto;
import kr.co.kbhealthcareproject.dto.response.DailyActivityResponseDto;
import kr.co.kbhealthcareproject.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    /**
     * Activity 데이터 저장
     * @param request
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> saveActivity(@RequestBody ActivityRequestDto request) {
        activityService.saveActivityData(request);
        return ResponseEntity.ok().build();
    }

    /**
     * 일별 Activity 데이터 조회
     * @param recordKey
     * @return
     */
    @GetMapping("/daily")
    public ResponseEntity<List<DailyActivityResponseDto>> getDailyActivityData(@RequestParam String recordKey) {
        return ResponseEntity.ok(activityService.getDailyActivityData(recordKey));
    }
}
