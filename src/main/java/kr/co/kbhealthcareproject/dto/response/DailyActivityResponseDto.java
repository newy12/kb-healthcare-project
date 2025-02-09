package kr.co.kbhealthcareproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DailyActivityResponseDto implements Serializable {
    @JsonProperty(value = "Daily")
    private String daily;
    @JsonProperty(value = "Steps")
    private int totalSteps;
    @JsonProperty(value = "calories")
    private int totalCalories;
    @JsonProperty(value = "distance")
    private BigDecimal totalDistance;
    @JsonProperty(value = "recordkey")
    private String recordKey;

    public DailyActivityResponseDto(String daily, int totalSteps, int totalCalories, BigDecimal totalDistance, String recordKey) {
        this.daily = daily;
        this.totalSteps = totalSteps;
        this.totalCalories = totalCalories;
        this.totalDistance = totalDistance;
        this.recordKey = recordKey;
    }
}
