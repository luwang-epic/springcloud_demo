package com.learning.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * springcloud配置中心启动类
 * @author wanglu
 * @date 2020/01/05
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

    /**
     *  分布式配置中心需要哪些组件
     *      1. web管理系统
     *          后台可以使用图形界面管理配置文件 但是springcloud config没有提供图形化管理配置文件
     *      2. 存放分布式配置文件服务器（持久化存储服务器）
     *          使用版本控制器存放配置文件信息，一般使用git/svn
     *      3. ConfigServer缓存配置文件服务器
     *          临时缓存存放，从git上面拉取的，一般是磁盘和内存都需要缓存，供ConfigClient读取
     *      4. ConfigClient读取ConfigServer配置文件信息
     *
     *  如何将配置文件
     *      1. 在git环境上创建文件命名规范
     *          服务名称-环境.properties 或者 服务名称-环境.yml
     *                  如：环境一般包括：dev(本地环境/开发环境） sit（测试环境） pre（预上线环境） prd（生产环境）
     *      2. 访问git环境上配置文件的地址
     *          host + 文件名
     *                  如：http://127.0.0.1:5001/springcloud-config-server-sit.properties
     *
     *
     *  刷新策略：
     *      1. 默认情况下不能及时的获取实时变更的配置文件信息
     *      2. SpringCloud分布式配置中心可以采取手动刷新或者自动刷新，都不需要重启服务器
     *          手动刷新：需要人工调用接口，读取最新配置文件，同时相关bean上面需要加上@RefreshScope注解
     *              接口为：http://springcloud-config-client/actuator/refresh  （post请求）
     *              一般会将需要动态更新的配置放到一个配置类上面，然后在该配置类上面加上@RefreshScope注解
     *          自动刷新： 消息总线进行实时通知
     *              不建议使用自动刷新功能，对性能影响较大，建议修改完配置文件后，人工调用/actuator/refresh接口进行刷新
     */

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
