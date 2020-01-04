package com.learning.api.order.service;

import com.learning.api.order.feign.MemberFeignApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 实现订单服务
 * @author wanglu
 * @date 2020/01/04
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private MemberFeignApi memberFeignApi;

    public String getUserByFeign(String name) {
        return "通过Feign客户端，调用会员服务获取用户信息：" + memberFeignApi.getUser(name);
    }
}
