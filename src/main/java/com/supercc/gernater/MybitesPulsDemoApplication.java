package com.supercc.gernater;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableSwaggerBootstrapUI
@MapperScan(basePackages = "com.supercc.gernater.dao")
@SpringBootApplication
public class MybitesPulsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybitesPulsDemoApplication.class, args);
    }

}
