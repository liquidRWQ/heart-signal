package com.company.heartbeatsignal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class HeartbeatSignalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartbeatSignalApplication.class, args);
	}

}
