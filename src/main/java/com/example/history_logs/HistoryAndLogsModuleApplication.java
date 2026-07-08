package com.example.history_logs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HistoryAndLogsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoryAndLogsModuleApplication.class, args);
	}
}
