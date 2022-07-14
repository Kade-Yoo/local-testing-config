package yoo.example.localtestingconfig.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yoo.example.localtestingconfig.entity.MemberEntity;
import yoo.example.localtestingconfig.model.MemberDto;
import yoo.example.localtestingconfig.repository.MemberCustomRepository;
import yoo.example.localtestingconfig.repository.MemberRepository;
import yoo.example.localtestingconfig.service.MemberService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

/**
 * Service Layer Test
 */
@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberCustomRepository memberCustomRepository;

    @Test
    void getUser() {
        Long userId = 1L;

        MemberEntity member = createMember();
        given(memberRepository.findById(userId))
                .willReturn(Optional.ofNullable(member));

        MemberDto user = memberService.getUser(userId);

        assertEquals(user.getMemberName(), member.getMemberName());
        assertEquals(user.getPassword(), member.getPassword());
    }

    private MemberEntity createMember() {
        return MemberEntity.builder()
                .memberName("").password("")
                .build();
    }
}