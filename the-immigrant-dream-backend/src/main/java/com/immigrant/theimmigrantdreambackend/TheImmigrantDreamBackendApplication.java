package com.immigrant.theimmigrantdreambackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@OpenAPIDefinition(
		info = @Info(
				title = "The Immigrant Dream Project",
				version = "1.0.0",
				description = "This project is to implement The Immigrant Dream Backend Service.",
				termsOfService = "the-immigrant-dream",
				contact = @Contact(
						name = "The Immigrant Dream",
						email = "theimmidream@gmail.com"
				),
				license = @License(
						name = "license",
						url	= ""
				)
		)
)
public class TheImmigrantDreamBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheImmigrantDreamBackendApplication.class, args);
	}

}
