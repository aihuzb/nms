package com.andi.nms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.andi.nms.*"})
public class NmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(NmsApplication.class, args);
	}
}
