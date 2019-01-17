package com.patryk.application;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.patryk.application.services.StorageService;

@SpringBootApplication
public class SalesHunterAppApplication {
	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SalesHunterAppApplication.class, args);
	}
	public void run(String... arg) throws Exception {
		
		storageService.init();
	}
}
