package com.supercc.gernater.config;/**
 * @author wangcc
 * @create
 */

import org.springframework.beans.factory.annotation.Value;
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
 * @ClassName SwaggerConfig
 * @Description Swagger2配置文件
 * @Author wangcc
 * @Date 9:49 2019/11/26
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.supercc.gernater.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(enableSwagger);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("小豆丁后端api接口文档")
                // 描述
                .description("欢迎访问小豆丁后端api接口文档，这里是描述信息")
                // 设置联系人
                .contact(new Contact("小豆丁", "http://127.0.0.1/swagger-ui.html", "247410779@qq.com"))
                // 定义版本号
                .version("1.0")
                .build();
    }
}
