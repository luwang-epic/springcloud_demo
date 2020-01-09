package com.learning.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanglu
 * @date 2020/01/05
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     * RefreshScope注解：动态刷新配置需要的注解，如：刷新name值
     */

    @Value("${name}")
    private String name;

    @GetMapping("/config/getName")
    public String getName() {
        return name;
    }
}
