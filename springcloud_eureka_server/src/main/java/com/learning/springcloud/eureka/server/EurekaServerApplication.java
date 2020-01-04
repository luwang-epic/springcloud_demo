package com.learning.springcloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wanglu
 * @date 2020/01/01
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    /**
     * EnableEurekaServer注解 表示开启EurekaServer服务 开启注册中心
     *      springcloud支持3种注册中心：eureka，zookeeper，consul
     *
     * 首先对Eureka注册中心需要了解的是Eureka各个节点都是平等的，没有ZK中角色的概念， 即使N-1个节点挂掉也不会影响其他节点的正常运行。
     *
     * 默认情况下，如果Eureka Server在一定时间内（默认90秒）没有接收到某个微服务实例的心跳，Eureka Server将会移除该实例。
     * 但是当网络分区故障发生时，微服务与Eureka Server之间无法正常通信，而微服务本身是正常运行的，此时不应该移除这个微服务，所以引入了自我保护机制。
     *          Eureka Server 在运行期间会去统计心跳失败比例在 15 分钟之内是否低于 85%，如果低于 85%，Eureka Server 会将这些实例保护起来，让这些实例不会过期，
     *          但是在保护期内如果服务刚好这个服务提供者非正常下线了，此时服务消费者就会拿到一个无效的服务实例，此时会调用失败，对于这个问题需要服务消费者端要有一些容错机制，如重试，断路器等。
     *
     * springcloud中支持两种客户端调用工具
     *      Rest RestTemplate 基本上不用的
     *      Feign客户端工具，以后在实际开发中用的最多
     *          Feign是一个声明式的Http客户端调用工具，采用接口+注解方式实现，易读性比较强
     */

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
