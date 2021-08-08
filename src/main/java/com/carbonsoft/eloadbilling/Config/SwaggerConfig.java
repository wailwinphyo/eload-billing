package com.carbonsoft.eloadbilling.Config;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final Contact DEFAULT_CONTACT = new Contact("CarbonSoft",
			"https://github.com/wailwinphyo/restful-web-serivces", "wailwinphyo.dev@gmail.com");

	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("E-load Billing Api Documentation",
			"E-load Billing Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());;
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = null;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}
