package kr.co.kbhealthcareproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class ActivityRequestDto {
    private String recordkey;
    private DataDto data;

    @Data
    public static class DataDto {
        private String memo;
        private List<EntryDto> entries;
    }

    @Data
    public static class EntryDto {
        private PeriodDto period;
        private DistanceDto distance;
        private CaloriesDto calories;
        private Object steps;

        @Data
        public static class PeriodDto {
            private String from;
            private String to;
        }

        @Data
        public static class DistanceDto {
            private double value;
            private String unit;
        }

        @Data
        public static class CaloriesDto {
            private double value;
            private String unit;
        }
    }
}
