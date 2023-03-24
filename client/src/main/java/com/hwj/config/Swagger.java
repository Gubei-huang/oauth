package com.hwj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置
 * @author Huang
 */
//@Configuration
//@EnableOpenApi
public class Swagger {
//    @Bean
//    public Docket docket(){
//
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .enable(true)
//                .groupName("HWJ")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hwj.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//
//    @SuppressWarnings("all")
//    public ApiInfo apiInfo(){
//        return new ApiInfo(
//                "Huangweijie's api",
//                "redis project",
//                "v1.0",
//                "2261839618@qq.com", //开发者团队的邮箱
//                "HWJ",
//                "Apache 2.0",  //许可证
//                "http://www.apache.org/licenses/LICENSE-2.0" //许可证链接
//        );
//    }

}