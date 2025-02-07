package kr.co.kbhealthcareproject.entity;

import jakarta.persistence.*;
import kr.co.kbhealthcareproject.entity.enums.OsType;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
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
    private String id;

    @Column(name = "record_key", nullable = false, unique = true)
    @Comment(value = "레코드키")
    private String recordKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "os_type", nullable = false)
    @Comment(value = "운영체제")
    private OsType osType;

    @Comment(value = "메모")
    private String memo;

    @OneToMany(mappedBy = "activityRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActivityEntry> entries;

    @CreationTimestamp
    @Comment(value = "등록일시")
    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime regDate;

    public void setEntries(List<ActivityEntry> entries) {
        if (this.entries == null) {
            this.entries = new ArrayList<>();
        }
        this.entries.clear();
        this.entries.addAll(entries);
    }
}
