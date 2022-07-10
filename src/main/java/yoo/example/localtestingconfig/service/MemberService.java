package yoo.example.localtestingconfig.service;

import yoo.example.localtestingconfig.model.MemberDto;

public interface MemberService {

    MemberDto getUser(Long userId);
}
