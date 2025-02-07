package kr.co.kbhealthcareproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(schema = "kb", name = "activity_entry")
public class ActivityEntry {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(38)")
    @Comment(value = "활동엔트리 키값")
    private String id;

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
