package com.example.user;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@ComponentScan
//@Configuration
//@EnableAutoConfiguration
@Slf4j
public class UserApplication {
	static final Logger logger = LoggerFactory.getLogger(UserApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		logger.info("Hello from Logger");
		logger.error("Hello from Logger");
		logger.warn("Hello from Logger");
		logger.debug("Hello from Logger");
//		log.info("Hello from Log4j");
	}
}
