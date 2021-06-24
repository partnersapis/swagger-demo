package com.booking.Item.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * This method filter the controller and methods for Swagger Documentation
	 */
	@Bean
	public Docket itemApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.booking.Item.controller")).paths(regex("/items.*"))
				.build()
				.apiInfo(metaData());        
	}

	/*
	 * This method returns information about the API
	 */
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot Rest API", "Spring Boot Rest API for Item", "1.0",
				"Terms of Service", new Contact("Ravina", "https://www.google.com", "test@email.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

}
