package com.photon.health.advisory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
