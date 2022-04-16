package com.jforce.tr.sqluygulama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jforce.tr"})
@EntityScan(basePackages = {"com.jforce.tr"})
public class SqlUygulamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlUygulamaApplication.class, args);
	}

}
