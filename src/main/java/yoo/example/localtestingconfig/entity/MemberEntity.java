package yoo.example.localtestingconfig.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String password;
    private String memberName;

    @Builder
    public MemberEntity(String password, String memberName) {
        this.password = password;
        this.memberName = memberName;
    }
}
