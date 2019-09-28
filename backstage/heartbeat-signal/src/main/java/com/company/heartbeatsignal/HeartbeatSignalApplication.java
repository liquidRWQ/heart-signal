package com.company.heartbeatsignal;

import com.company.heartbeatsignal.task.TokenTimer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper")
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class HeartbeatSignalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartbeatSignalApplication.class, args);
		TokenTimer.start();
	}

}
