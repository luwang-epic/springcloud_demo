package com.learning.api.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 订单服务启动类，该服务中调用会员服务
 * @author wanglu
 * @date 2020/01/03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderApplication {

    /**
     * EnableFeignClients 开启Feign客户端的权限
     */

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
