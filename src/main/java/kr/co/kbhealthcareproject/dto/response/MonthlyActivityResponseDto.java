package kr.co.kbhealthcareproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MonthlyActivityResponseDto implements Serializable {
    @JsonProperty(value = "Monthly")
    private String monthly;
    @JsonProperty(value = "Steps")
    private int totalSteps;
    @JsonProperty(value = "calories")
    private int totalCalories;
    @JsonProperty(value = "distance")
    private BigDecimal totalDistance;
    @JsonProperty(value = "recordkey")
    private String recordKey;

    public MonthlyActivityResponseDto(String monthly, int totalSteps, int totalCalories, BigDecimal totalDistance, String recordKey) {
        this.monthly = monthly;
        this.totalSteps = totalSteps;
        this.totalCalories = totalCalories;
        this.totalDistance = totalDistance;
        this.recordKey = recordKey;
    }
}
