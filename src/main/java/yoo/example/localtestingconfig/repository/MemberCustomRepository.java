package yoo.example.localtestingconfig.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yoo.example.localtestingconfig.entity.MemberEntity;

@Repository
@RequiredArgsConstructor
public class MemberCustomRepository {

    private final MemberRepository memberRepository;

    public MemberEntity getMemer(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("조회된 멤버가 없습니다."));
    }
}
