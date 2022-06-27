package com.wipro.MongoDB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket demoAPI() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).groupName("MongoDB-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.wipro.MongoDB.controller")).build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("My API")
				.contact(new Contact("shad", "http://www.shad.com", "shad@abc.com"))
				.description("This is for Learning Purpose")
				.license("Restricted Users")
				.licenseUrl("http://www.papa.com")
				.termsOfServiceUrl("http://www.mummy.com")
				.version("2022.6.1")				
				.build();
	}

}