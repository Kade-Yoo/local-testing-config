package yoo.example.localtestingconfig.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yoo.example.localtestingconfig.model.MemberDto;
import yoo.example.localtestingconfig.repository.MemberCustomRepository;
import yoo.example.localtestingconfig.service.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberCustomRepository memberRepository;

    @Override
    public MemberDto getUser(Long memberId) {
        return MemberDto.of(memberRepository.getMemer(memberId));
    }
}
