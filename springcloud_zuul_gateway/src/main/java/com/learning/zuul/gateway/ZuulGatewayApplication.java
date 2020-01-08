package com.learning.zuul.gateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * zuul网关启动类
 *      网关一般也是做成集群的，这里的集群是不同于一般的集群，这里其实是每个独立运行的服务，各个服务之间并不互相通讯
 *      一般做法是启动几个不同端口的zuul网关，部署在不同的机器上面，然后由nginx将请求打到不同的zuul网关上
 *          比如：有zuul:81和zuul:82两个zuul网关服务，nginx根据累计请求次数，
 *               如果是偶数次将请求发送到zuul:81这个服务，如果是奇数次将请求转发到zuul:82这个服务
 * @author wanglu
 * @date 2020/01/06
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
public class ZuulGatewayApplication {

    /**
     * EnableZuulProxy注解表示开启网关代理
     * EnableSwagger2Doc注解表示开启生成swagger文档服务
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


    /**
     * 添加文档来源，用于展示该网关的各个服务api文档
     */
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List<SwaggerResource> swaggerResources = new ArrayList<>();
            //userToken=122只是为了跳过网关拦截
            swaggerResources.add(swaggerResource("order", "/springcloud-order/v2/api-docs?userToken=122", "2.0"));
            return swaggerResources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            //文档上面的选择框里面的选项名称
            swaggerResource.setName(name);
            //对于文档服务的地址，一般为项目名称/v2/api-docs
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
