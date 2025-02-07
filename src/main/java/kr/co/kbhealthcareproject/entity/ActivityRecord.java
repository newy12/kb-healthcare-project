package kr.co.kbhealthcareproject.entity;

import jakarta.persistence.*;
import kr.co.kbhealthcareproject.entity.enums.OsType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "activity_record")
public class ActivityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_key", nullable = false, unique = true)
    private String recordKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "os_type", nullable = false)
    private OsType osType;

    private String memo;

    @OneToMany(mappedBy = "activityRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActivityEntry> entries = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime regDate;

    public void setEntries(List<ActivityEntry> entries) {
        this.entries.clear();
        this.entries.addAll(entries);
    }
}
