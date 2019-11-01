package com.ssafy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.groupName("emp")	//서비스  할 project이름 이나 domain이름
						.apiInfo(info())		//스웨거 화면에 표시 할 설명정보
						.select()
						.apis(RequestHandlerSelectors.basePackage("com.ssafy.controller"))
						.build();
	}

	private ApiInfo info() {
		return new ApiInfoBuilder().title("Employee Management API")
							.description("Employee 관리를 위한 <b>CRUD</b>")
							.license("  어쩌구 저쩌구 ")
							.version("3.0")
							.build();
	}						
	
	
	
}
