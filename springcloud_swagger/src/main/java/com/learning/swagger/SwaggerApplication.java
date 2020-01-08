package com.learning.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * springboot 整合 swagger应用， 自动生成api文档 启动类
 * @author wanglu
 * @date 2020/01/08
 */
@SpringBootApplication
@EnableEurekaClient
public class SwaggerApplication {

    /**
     * 可以通过 http://localhost:7001/swagger-ui.html 访问文档
     */

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

}
