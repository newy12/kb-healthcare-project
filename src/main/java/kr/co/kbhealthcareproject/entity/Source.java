package kr.co.kbhealthcareproject.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(schema = "kb", name = "source")
public class Source {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(38)")
    @Comment(value = "소스 키값")
    private String id;

    @Comment(value = "제품명")
    private String productName;
    @Comment(value = "제조사")
    private String vender;
    @Comment(value = "타입")
    private String type;
    @Comment(value = "모드")
    private Integer mode;
    @Comment(value = "이름")
    private String name;

    @OneToOne(mappedBy = "source", fetch = FetchType.LAZY)
    private ActivityRecord activityRecord;


}
