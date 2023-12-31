package com.moviebookingApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Adjust the allowed origin to match your Angular application's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedMethods("/", "/actuator", "/actuator/prometheus")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    
    
}