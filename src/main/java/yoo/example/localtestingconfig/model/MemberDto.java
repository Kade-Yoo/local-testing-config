package yoo.example.localtestingconfig.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yoo.example.localtestingconfig.entity.MemberEntity;

@Getter
@NoArgsConstructor
public class MemberDto {

    private Long memberId;
    private String password;
    private String memberName;

    public MemberDto(Long memberId, String password, String memberName) {
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
    }

    public static MemberDto of(MemberEntity entity) {
        return new MemberDto(entity.getMemberId(), entity.getPassword(), entity.getMemberName());
    }

}
