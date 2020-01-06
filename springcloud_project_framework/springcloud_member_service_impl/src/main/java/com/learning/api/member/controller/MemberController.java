package com.learning.api.member.controller;

import com.learning.api.member.domain.User;
import com.learning.api.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanglu
 * @date 2020/01/04
 */
@Slf4j
@RestController
public class MemberController {

    @Resource(name = "memberServiceImpl")
    private MemberService memberService;

    @GetMapping("/member/getUser")
    public User getUser(String name) {
        log.info("MemberController getUser with name: {}", name);
        return memberService.getUser(name);
    }

    @GetMapping("/member/timeout")
    public String timeoutMethod() {
        log.info("MemberController timeoutMethod...");
        return memberService.timeoutMethod();
    }
}
