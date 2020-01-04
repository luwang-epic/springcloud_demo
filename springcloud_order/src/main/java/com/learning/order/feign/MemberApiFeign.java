package com.learning.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过Feign客户端来调用接口
 * @author wanglu
 * @date 2020/01/04
 */
@Component
@FeignClient(name = "springcloud-member")
public interface MemberApiFeign {

    /**
     * Feign 书写方式以SpringMVC接口形式书写
     * FeignClient注解调用服务接口name，就是服务名称
     */
    @GetMapping("/member/getMember")
    String getMember();

    /**
     * 必须加RequestParam注解，表示参数为名称为name，而不是body体
     */
    @GetMapping("/member/getUserInfo")
    String getUserInfo(@RequestParam("name") String name);
}
