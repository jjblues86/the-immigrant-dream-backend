package com.immigrant.theimmigrantdreambackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TheImmigrantDreamBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheImmigrantDreamBackendApplication.class, args);
	}

}
