package com.myride.notification.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
@Configuration
@EnableSwagger2
public class SwaggerDocumentionConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("My Ride").description("My Ride description").version("1.0.0").build();
		
	}
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json"));
	
	@Bean
	public Docket customImplementation() {
		
		return new Docket(DocumentationType.SWAGGER_2).consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES).select()
				.apis(RequestHandlerSelectors.basePackage("com.myride.notification.controller"))
				.paths(regex("/.*")).build().apiInfo(apiInfo());
	}
	
	/*
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth()).
	 * forPaths(regex("/.*")).build(); }
	 * 
	 * 
	 * 
	 * 
	 * List<SecurityReference> defaultAuth(){ AuthorizationScope authorizationScope
	 * = new AuthorizationScope("global", "accessEveryThing"); AuthorizationScope[]
	 * authorizationScopes = new AuthorizationScope[1]; authorizationScopes[0]=
	 * authorizationScope;
	 * 
	 * return Lists.newArrayList(new SecurityReference("JWT",authorizationScopes));
	 * 
	 * }
	 * 
	 * private ApiKey jwtToken() { return new ApiKey("JWT",
	 * HttpHeaders.AUTHORIZATION, "header");
	 * 
	 * }
	 */
	 
	 
}
