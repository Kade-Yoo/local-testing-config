package yoo.example.localtestingconfig.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yoo.example.localtestingconfig.model.MemberDto;
import yoo.example.localtestingconfig.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/local-test-config/user")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{userId}")
    public MemberDto getUser(@PathVariable Long userId) {
        return memberService.getUser(userId);
    }
}
