package com.visma.demowholesalers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Starting point of web app
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
public class DemoWholesalersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWholesalersApplication.class, args);
	}

}
