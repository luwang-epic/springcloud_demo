package com.learning.order.controller;

import com.learning.order.feign.MemberApiFeign;
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
@RequestMapping("/order")
public class OrderController {
    /**
     * RestTemplate 是有SpringBoot Web组件提供 默认整合ribbon负责均衡器
     *      rest方式底层是采用httpclient技术
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberApiFeign memberApiFeign;

    /**
     * 订单服务调用会员服务
     *
     * 在springcloud中有两种方式调用rest，fegin（SpringCloud)
     */
    @GetMapping("/getOrder")
    public String getOrder() {
        //有两种方式，一种采用服务别名方法调用，另一种是直接调用
        //直接调用
        //String url = "http://127.0.0.1:3001/member/getMember";
        //使用别名去注册中心上获取对应的服务调用地址
        String url = "http://springcloud-member/member/getMember";
        String result = restTemplate.getForObject(url, String.class);
        result = "订单服务调用会员服务： " + result;
        log.info("getOrder --> {}", result);
        return result;
    }


    /**
     * 使用feign客户端调用member服务
     */
    @GetMapping("/feignMember")
    public String getOrderByFeign() {
        return "在订单服务中通过Feign客户端访问会员服务：" + memberApiFeign.getMember();
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(String name) {
        return "在订单服务中通过Feign客户端访问会员服务：" + memberApiFeign.getUserInfo(name);
    }
}
