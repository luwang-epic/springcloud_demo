package com.learning.member.api.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api包或者api类表示对外提供的api服务，而不是用于前端页面的
 * @author wanglu
 * @date 2020/01/03
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberApiController {

    @GetMapping("/")
    public String index() {
        return "我是会员服务";
    }

    @GetMapping("/getMember")
    public String getMember() {

        return "this is member, 我是会员服务！";
    }

    /**
     * 获取用户信息，该接口模拟时间较长的访问
     */
    @GetMapping("/getUserInfo")
    public String getUserInfo(String name) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        log.info("调用会员服务的getUserInfo方法...");
        return  String.format("调用会员服务获取用户信息: %s，该接口很慢！", name);
    }
}
