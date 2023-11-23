package com.example.konectaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class KonectaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KonectaApiApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer(){

	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry){
			registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE");
		}
	};
	}

}
