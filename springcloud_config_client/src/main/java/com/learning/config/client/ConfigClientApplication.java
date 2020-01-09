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
     *
     * 手动刷新：需要人工调用接口，读取最新配置文件，同时相关bean上面需要加上@RefreshScope注解
     *                   接口为：http://springcloud-config-client/actuator/refresh  （post请求）
     *                   一般会将需要动态更新的配置放到一个配置类上面，然后在该配置类上面加上@RefreshScope注解
     */

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
