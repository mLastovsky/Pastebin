package com.mlastovsky.pastebin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PastebinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PastebinApiApplication.class, args);
	}

}
