package com.learning.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示swagger自动生成文档controller
 * @author wanglu
 * @date 2020/01/08
 */
@Api("SwaggerController")
@Slf4j
@RestController
public class OrderSwaggerController {

    @ApiOperation("swagger演示")
    @GetMapping("/order/swagger")
    public String orderSwagger(String name) {
        log.info("SwaggerController swaggerIndex ---> {}", name);
        return "swagger index ---> " + name;
    }
}
