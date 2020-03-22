package com.xdj.spring.boot.swagger;

/**
 * created by Jay on 2019/9/16
 */

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2的接口配置
 *
 * @author Lion Li
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                // 详细定制
                .apiInfo(apiInfo())
                .select()
                // 指定当前包路径 (扫描所有带ApiOperation注解的类)
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描所有
                //.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("标题：XXXX_接口文档")
                .description("描述：XXX项目文档")
                .contact(new Contact("project-a", null, null))
                .version("版本号:1.0")
                .build();
    }
}