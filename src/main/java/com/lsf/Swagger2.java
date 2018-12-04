//
//package com.lsf;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//
//@Configuration //必须存在
//@EnableSwagger2 //必须存在
//@EnableWebMvc //必须存在
//@ComponentScan(basePackages = {"com.lsf.controller"}) //必须存在 扫描的API Controller package name 也可以直接扫描class (basePackageClasses)
//public class Swagger2{
//    @Bean
//    public Docket customDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        Contact contact = new Contact("小明", "http://www.cnblogs.com/getupmorning/", "zhaoming0018@126.com");
//        return new ApiInfoBuilder()
//                .title("前台API接口")
//                .description("前台API接口")
//                .contact(contact)
//                .version("1.1.0")
//                .build();
//    }
//}