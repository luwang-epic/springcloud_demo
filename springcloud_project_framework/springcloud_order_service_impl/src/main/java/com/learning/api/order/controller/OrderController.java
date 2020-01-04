package com.learning.api.order.controller;

import com.learning.api.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanglu
 * @date 2020/01/04
 */
@RestController
public class OrderController {

    @Resource(name = "orderServiceImpl")
    private OrderService orderService;

    @GetMapping("/order/getUserByFeign")
    public String getUserByFeign(String name) {
        return orderService.getUserByFeign(name);
    }
}
