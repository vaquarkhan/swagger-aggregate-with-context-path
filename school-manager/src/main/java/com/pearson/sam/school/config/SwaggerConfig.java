package com.pearson.sam.school.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.pearson.sam.school")).paths(regex("/api.*")).build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("API Documentation - School Manager", "", "", "", "", "", "");

		return apiInfo;
	}
}
