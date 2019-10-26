package com.txku.springstartkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SuppressWarnings("PMD.UseUtilityClass")
@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
@EnableHystrix
public class SpringStartkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartkitApplication.class, args);
	}

}
