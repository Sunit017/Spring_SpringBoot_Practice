package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoAppApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringDemoAppApplication.class, args);
		Dev obj=context.getBean(Dev.class);
		obj.build();
	}

}
