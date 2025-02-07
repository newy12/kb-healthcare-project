package kr.co.kbhealthcareproject.controller;

import kr.co.kbhealthcareproject.dto.ActivityRequestDto;
import kr.co.kbhealthcareproject.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
