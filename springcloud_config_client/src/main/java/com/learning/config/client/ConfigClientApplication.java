package com.learning.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * springcloud配置中心客户端启动类
 * @author wanglu
 * @date 2020/01/05
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {

    /**
     * 介绍Springcloud的客户端的搭建。在这个地方，我是实力踩坑啊，
     *      对于配置中心的springboot启动的配置文件，必须命名为bootstrap.yml或bootstrap.properties
     *          一定不能命名为application.**，否则就会走默认的路径 http://localhost:8888
     */

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
