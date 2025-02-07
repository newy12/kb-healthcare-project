package kr.co.kbhealthcareproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "activity_entry")
public class ActivityEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private ActivityRecord activityRecord;

    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime periodFrom;

    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime periodTo;

    private double distanceValue;

    private String distanceUnit;

    private double caloriesValue;

    private String caloriesUnit;

    private double steps;
}
