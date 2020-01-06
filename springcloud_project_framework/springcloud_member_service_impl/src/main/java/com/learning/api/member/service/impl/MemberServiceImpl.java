package com.learning.api.member.service.impl;

import com.learning.api.member.domain.User;
import com.learning.api.member.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 会员服务， 可以直接用这个类作为controller层，暴露给其他服务调用
 *              因为接口是没有界面的，因此可以做也不会感到突兀
 * @author wanglu
 * @date 2020/01/04
 */
@Service
public class MemberServiceImpl implements MemberService {

    public User getUser(String name) {
        Integer age = new Random().nextInt(20) + 10;
        return new User(name, age);
    }

    public String timeoutMethod() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return "正常返回了";
    }
}
