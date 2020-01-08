package com.learning.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外api函数
 * @author wanglu
 * @date 2020/01/08
 */
@Api("SwaggerDemo")
@Slf4j
@RestController
public class SwaggerController {

    @ApiOperation("swagger某一个接口")
    @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String")
    @GetMapping("/swagger/index")
    public String swaggerIndex(String name) {
        log.info("SwaggerController swaggerIndex ---> {}", name);
        return "swagger index ---> " + name;
    }
}
