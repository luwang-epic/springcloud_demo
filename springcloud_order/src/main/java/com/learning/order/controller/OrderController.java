package com.learning.order.controller;

import com.learning.order.feign.MemberApiFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
        log.info("getUserInfo方法的线程池名称：{}", Thread.currentThread().getName());
        return "在订单服务中通过Feign客户端访问会员服务：" + memberApiFeign.getUserInfo(name);
    }

    /**
     * HystrixCommand注解 是服务降级注解，当该方法阻塞时会调用fallbackMethod指定的方法
     *      默认开启线程池隔离方式、服务降级和服务熔断 可以观察getUserInfo和getUserInfoWithHystrix方法的线程池名称
     *      调用接口超时（默认是1秒），默认情况下业务逻辑是可以执行的，但是直接降级到fallbackMethod方法
     * fallbackMethod：指定一个方法名
     *
     * 这种方式做服务降级会多出很多重复代码，而且getUserInfoWithHystrix方法和memberApiFeign.getUserInfo是在一个线程中的
     *      通常情况下只是调用外部memberApiFeign.getUserInfo这个接口慢，只需要将这个接口作降级就可以了
     *      因此一般做服务降级的做法是使用类的方式，具体见springcloud_project_framework中的代码
     */
    @HystrixCommand(fallbackMethod = "getUserInfoHystrixFallback")
    @GetMapping("/getUserInfoWithHystrix")
    public String getUserInfoWithHystrix(String name) {
        log.info("getUserInfoWithHystrix方法的线程池名称：{}", Thread.currentThread().getName());
        return "在订单服务中通过Feign客户端访问会员服务：" + memberApiFeign.getUserInfo(name);
    }

    /**
     * 该方法的返回值和参数必须和getUserInfoWithHystrix一致，否则报错
     */
    public String getUserInfoHystrixFallback(String name) {
        log.info("服务降级到getUserInfoHystrixFallback方法...");
        return name + "返回一个友好的提示：服务降级，请稍后重试";
    }
}
