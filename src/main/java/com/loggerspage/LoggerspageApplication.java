package com.loggerspage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.loggerspage.dao")
public class LoggerspageApplication extends SpringBootServletInitializer {
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(LoggerspageApplication.class);
	}

	public static void main(
			String[] args) {
		SpringApplication.run(LoggerspageApplication.class, args);
	}
}
