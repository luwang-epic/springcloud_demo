package com.learning.member.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api包或者api类表示对外提供的api服务，而不是用于前端页面的
 * @author wanglu
 * @date 2020/01/03
 */
@RestController
@RequestMapping("/member")
public class MemberApiController {

    @GetMapping("/getMember")
    public String getMember() {

        return  "this is member, 我是会员服务！";
    }
}
