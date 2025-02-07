package kr.co.kbhealthcareproject.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class ActivityRequestDto {
    private String recordkey;
    private DataDto data;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z")
    private ZonedDateTime lastUpdate;
    private String type;

    @Data
    public static class DataDto {
        private String memo;
        private List<EntryDto> entries;
        private SourceDto source;
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

    @Data
    public static class SourceDto {
        private ProductDto product;  // product 정보를 저장
        private String type;
        private int mode;
        private String name;

        @Data
        public static class ProductDto {
            private String name;
            private String vender;
        }
    }
}
