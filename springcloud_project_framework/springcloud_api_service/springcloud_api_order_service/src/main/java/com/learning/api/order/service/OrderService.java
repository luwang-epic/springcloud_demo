package com.learning.api.order.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单服务接口
 * @author wanglu
 * @date 2020/01/04
 */
public interface OrderService {

    @GetMapping("/order/getOrder")
    String getUserByFeign(String name);
}
