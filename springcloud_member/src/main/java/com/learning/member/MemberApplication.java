package com.learning.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * member服务启动类， 该服务提供给订单服务调用
 * @author wanglu
 * @date 2020/01/03
 */
@SpringBootApplication
@EnableEurekaClient
public class MemberApplication {

    /**
     * EnableEurekaClient注解表示需要将当前服务注册到eureka上
     */

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

}
