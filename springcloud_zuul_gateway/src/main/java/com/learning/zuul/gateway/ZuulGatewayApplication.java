package com.learning.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * zuul网关启动类
 * @author wanglu
 * @date 2020/01/06
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulGatewayApplication {

    /**
     * EnableZuulProxy注解表示开启网关代理
     *
     * EnableZuulServer注解，虽然也会创建一个Zuul服务端，但不加载任何反向代理过滤器，不使用Eureka的服务发现来发现其他服务。
     *         只在搭建自己的路由服务并不使用Zuul的预构建功能时使用。比如需要使用Zuul来配合其它不是Eureka的服务发现引擎，如Consul。
     *
     */

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    /**
     * RefreshScope注解： zuul配置能够使用config实现实时更新
     * @return
     */
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

}
