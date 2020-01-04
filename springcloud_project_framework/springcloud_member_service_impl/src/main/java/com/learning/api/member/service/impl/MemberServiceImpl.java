package com.learning.api.member.service.impl;

import com.learning.api.member.domain.User;
import com.learning.api.member.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 会员服务
 * @author wanglu
 * @date 2020/01/04
 */
@Service
public class MemberServiceImpl implements MemberService {

    public User getUser(String name) {
        Integer age = new Random().nextInt(20) + 10;
        return new User(name, age);
    }
}
