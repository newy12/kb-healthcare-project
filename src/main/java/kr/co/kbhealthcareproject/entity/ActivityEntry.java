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
    private String activity_entry_id;

    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private ActivityRecord activityRecord;

    @Comment(value = "활동 시작")
    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime periodTo;

    @Comment(value = "활동 끝")
    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime periodFrom;

    @Comment(value = "활동 거리")
    private double distanceValue;

    @Comment(value = "활동 거리 단위")
    @Column(length = 50)
    private String distanceUnit;

    @Comment(value = "칼로리")
    private double caloriesValue;

    @Comment(value = "칼로리 단위")
    @Column(length = 50)
    private String caloriesUnit;

    @Comment(value = "걸음 수")
    private double steps;
}
