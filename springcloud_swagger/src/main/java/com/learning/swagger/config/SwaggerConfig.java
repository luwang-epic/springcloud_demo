package com.learning.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 如果是引入swagger的jar包，需要这个配置
 *      如果直接引入springboot的swagger包，可以直接通过注解来配置 具体见order项目
 * @author wanglu
 * @date 2020/01/08
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * EnableSwagger2注解 开启swagger2
     */

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                //生成api扫包范围，这些包下的api将会被生成文档
                .apis(RequestHandlerSelectors.basePackage("com.learning.swagger.controller"))
                .paths(PathSelectors.any()).build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文档的标题
                .title("springcloud学习 | springboot整合swagger | 自动生成文档")
                //文档的描述
                .description("这个一个学习demo项目").termsOfServiceUrl("http://www.baidu.com")
                .version("1.0").build();
    }

}
