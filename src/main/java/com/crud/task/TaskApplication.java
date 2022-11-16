package com.crud.task;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TaskApplication/* extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
//		return application.sources(TaskApplication.class);
//	}

}
