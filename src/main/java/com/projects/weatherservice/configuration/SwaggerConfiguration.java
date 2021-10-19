package com.projects.weatherservice.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfiguration
 * 
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On 18-Oct-2021
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	/**
	 * Restricting swagger to look into mentioned paths <br>
	 * 
	 * @apiNote /v2/api-docs
	 * @return Docket
	 */
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				// service package
				.apis(RequestHandlerSelectors.basePackage("com.projects.weatherservice"))
				// building docket
				.build()
				// Setting API Information
				.apiInfo(getAPIInfo());
	}

	private ApiInfo getAPIInfo() {
		return new ApiInfo("Weather API", "Weather API by city, country and by polar coordinates", "1.0", "Public Service",
				new Contact("My Dream World", "NA", "NA"),
				"API Licence", "Apache", Collections.emptyList());
	}
}
