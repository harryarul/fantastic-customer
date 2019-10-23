package com.util.ms;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author arul
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket lifecycleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("customer")
                .select().apis(RequestHandlerSelectors.basePackage("com.util.ms.rest.controller"))
                //.paths(PathSelectors.regex("/customer.*"))
                .build()
                .apiInfo(metaData())
                .securitySchemes(Arrays.asList(apiKey()));
    }
    
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
        		"Customer Microservice",
                "Spring Boot REST API for Customer Service",
                "1.0",
                "Terms of service",
                new Contact("SAZI", "http://www.linkedin.com.au", "harryarul@yahoo.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());
        return apiInfo;
    }
    
    private ApiKey apiKey() {
        return new ApiKey("authkey", "jwt-key", "header");
    }
    
}
