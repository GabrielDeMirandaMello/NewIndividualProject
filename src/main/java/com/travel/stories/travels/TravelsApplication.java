package com.travel.stories.travels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.travel.stories.travels.internal.entity")
@EnableJpaRepositories(basePackages = "com.travel.stories.travels.internal.repository")
public class TravelsApplication {

	public static void main(String[] args) {

		SpringApplication.run(TravelsApplication.class, args);
	}

}
