package com.kimYunHyeong.sukiverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SukiverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SukiverseApplication.class, args);
	}

}
