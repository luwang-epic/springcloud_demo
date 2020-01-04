package com.learning.zookeeper.member.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 这里用的最新的springcloud版本进行踩坑，按照官网的例子，
 *          springcloud不会去zookeeper注册服务，通过阅读源码添加以上配置触发注册的事件
 * @author wanglu
 * @date 2020/01/04
 */
@Component
public class RegistrationConfig {

    @Autowired
    private AbstractAutoServiceRegistration serviceRegistration;

    @EventListener(WebServerInitializedEvent.class)
    public void register(WebServerInitializedEvent event) {
        serviceRegistration.bind(event);
    }
}
