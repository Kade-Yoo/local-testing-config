package yoo.example.localtestingconfig.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String password;
    private String memberName;
}
