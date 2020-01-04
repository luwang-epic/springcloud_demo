package com.learning.zookeeper.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * zk作为注册中心，订单服务启动类
 * @author wanglu
 * @date 2020/01/04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrderApplication.class, args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
