package com.devbelmel.spring_boot_docker;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	/**
	 * 
	 * @return to home page
	 */
	  @RequestMapping("/")
  		public String home() {
    		return "Hello Docker World";
  	}
	public static void main(String[] args) {

		SpringApplication app=new SpringApplication(SpringBootDockerApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","8083"));
        app.run(args);

	}

	/**
	 * 
	 * @param ctx
	 * @return
	 */
		@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
