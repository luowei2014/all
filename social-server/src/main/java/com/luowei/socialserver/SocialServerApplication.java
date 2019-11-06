package com.luowei.socialserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SocialServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialServerApplication.class, args);
	}

}
