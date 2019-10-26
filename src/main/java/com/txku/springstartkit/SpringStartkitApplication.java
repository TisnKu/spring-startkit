package com.txku.springstartkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SuppressWarnings("PMD.UseUtilityClass")
@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class SpringStartkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartkitApplication.class, args);
	}

}
