package com.learning.order;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 订单服务启动类，该服务中调用会员服务
 * @author wanglu
 * @date 2020/01/03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableSwagger2Doc
public class OrderApplication {

    /**
     * EnableFeignClients 开启Feign客户端的权限
     * EnableHystrix 开启Hystrix的权限
     * EnableSwagger2Doc 开启swagger文档服务
     *
     * 基于Hystrix解决服务雪崩效应原理：
     *      服务降级
     *          在高并发情况下，防止用户一直等待，使用服务降级方式（返回一个友好的提示直接给客户端，不会去处理请求，调用fallBack本地方法）
     *          目的是为了用户体验，如：秒杀的时候提示当前请求人数过多，请稍后重试。
     *          在规定的时间内没有响应给客户端，业务逻辑还是可以执行的，只是降级执行配置的服务降级方法
     *
     *      服务熔断
     *          服务熔断目的是为了保护服务，在高并发情况下，如果请求达到了一定的极限（可以自己设置阈值），如果流量超出了设置的阈值
     *          自动开启保护服务功能，使用服务降级方式返回一个友好的提示。熔断机制和服务降级一起使用
     *
     *      服务隔离
     *          分为线程池（一般常用）和信号量隔离
     *              线程池：每个服务接口都有自己独立的线程池，每个线程池互不影响，缺点：CUP占用率非常高。
     *                      不是所有的接口都会采用线程池隔离，核心关键接口才会采用
     *
     *
     */

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    /**
     * 注册RestTemplate到springboot容器中
     * 并用 @LoadBalanced 注解，用负载均衡策略请求服务提供者
     * 这是 Spring Ribbon 的提供的能力
     * 如果使用rest方法以别名方式进行调用，需要依赖ribbon负载均衡
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
