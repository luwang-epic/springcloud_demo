package com.learning.api.member.service;

import com.learning.api.member.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 会员接口
 * @author wanglu
 * @date 2020/01/04
 */
public interface MemberService {

    @GetMapping("/member/getUser")
    User getUser(@RequestParam("name") String name);

    /**
     * 比较耗时的方法，用于演示feign客户端和Hystrix做服务降级
     * @return 返回字符串
     */
    @GetMapping("/member/timeout")
    String timeoutMethod();

}
