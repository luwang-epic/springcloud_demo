package com.learning.zookeeper.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用zk作为注册中心的会员服务
 * @author wanglu
 * @date 2020/01/04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperMemberApplication {

    /**
     * EnableDiscoveryClient注解用于将信息注册到zk
     * 使用zk作为注册中心，需要先启动zk
     */

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperMemberApplication.class, args);
    }
}
