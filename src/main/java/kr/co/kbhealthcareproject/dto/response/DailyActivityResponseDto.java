package kr.co.kbhealthcareproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyActivityResponseDto {
    @JsonProperty(value = "Daily")
    private LocalDate daily;
    @JsonProperty(value = "Steps")
    private int totalSteps;
    @JsonProperty(value = "calories")
    private int totalCalories;
    @JsonProperty(value = "distance")
    private double totalDistance;
    @JsonProperty(value = "recordkey")
    private String recordKey;

    public DailyActivityResponseDto(LocalDate daily, int totalSteps, int totalCalories, double totalDistance, String recordKey) {
        this.daily = daily;
        this.totalSteps = totalSteps;
        this.totalCalories = totalCalories;
        this.totalDistance = totalDistance;
        this.recordKey = recordKey;
    }
}
