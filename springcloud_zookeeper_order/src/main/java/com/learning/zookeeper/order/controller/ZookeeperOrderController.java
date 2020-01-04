package com.learning.zookeeper.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单服务
 * @author wanglu
 * @date 2020/01/03
 */
@Slf4j
@RestController
@RequestMapping("/zookeeper/order")
public class ZookeeperOrderController {
    /**
     * RestTemplate 是有SpringBoot Web组件提供 默认整合ribbon负责均衡器
     *      rest方式底层是采用httpclient技术
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getOrder")
    public String getOrder() {
        String url = "http://zk-member/zookeeper/member/getMember";
        String result = restTemplate.getForObject(url, String.class);
        result = "订单服务调用会员服务： " + result;
        log.info("getOrder --> {}", result);
        return result;
    }
}
