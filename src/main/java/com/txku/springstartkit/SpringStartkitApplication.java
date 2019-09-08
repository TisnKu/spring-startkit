package com.txku.springstartkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringStartkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartkitApplication.class, args);
	}

}
