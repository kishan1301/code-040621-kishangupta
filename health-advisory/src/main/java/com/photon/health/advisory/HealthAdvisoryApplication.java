package com.photon.health.advisory;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kishan.gupta
 *
 */
@SpringBootApplication
@EnableSwagger2
public class HealthAdvisoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthAdvisoryApplication.class, args);
	}

	@Bean
	public Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/health/*"))
				.apis(RequestHandlerSelectors.basePackage("com.photon")).build().apiInfo(getApiInfo());
	}

	/**
	 * @return
	 */
	private ApiInfo getApiInfo() {
		return new ApiInfo("Health Advisory API",
				"API to provide health risks and BMI category by calculating the BMI basis provided details of height in cm and weight in kg",
				"1.0.0", "Open source",
				new Contact("Kishan Gupta", "www.linkedin.com/in/kishan1301", "kishangupta1301@gmail.com"),
				"API License", "https://www.linkedin.com/kishan1301", Collections.emptyList());
	}

}
