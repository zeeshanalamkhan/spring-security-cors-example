package com.zeeshan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
/* @CrossOrigin(origins = "*") */
public class MyPortalServerApplication {

	/* @CrossOrigin(origins = "http://localhost:9090") */
	@GetMapping("/access")
	public String greetings() {
		return "Welcome to learn CORS";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyPortalServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				/* registry.addMapping("/*").allowedOrigins("http://localhost:9090"); */
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}
}
