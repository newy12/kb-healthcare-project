package kr.co.kbhealthcareproject.entity;

import jakarta.persistence.*;
import kr.co.kbhealthcareproject.entity.enums.OsType;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(schema = "kb", name = "activity_record")
public class ActivityRecord {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(38)")
    @Comment(value = "활동레코드 키값")
    private String activity_record_id;

    @Column(name = "record_key", nullable = false, unique = true)
    @Comment(value = "레코드키")
    private String recordKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "os_type", nullable = false)
    @Comment(value = "OS 타입")
    private OsType osType;

    @Comment(value = "메모")
    private String memo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    private Source source;


    @OneToMany(mappedBy = "activityRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActivityEntry> entries;

    @CreationTimestamp
    @Comment(value = "등록일시")
    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime regDate;

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP(0)")
    @Comment(value = "최종 업데이트 일시")
    private ZonedDateTime lastUpdate;

    @Column(name = "type", nullable = false, length = 50)
    @Comment(value = "활동 타입")
    private String type;

    public void setEntries(List<ActivityEntry> entries) {
        if (this.entries == null) {
            this.entries = new ArrayList<>();
        }
        this.entries.clear();
        this.entries.addAll(entries);
    }


}
