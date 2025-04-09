package com.nikita.lab.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // ко всем эндпоинтам
                        .allowedOrigins("*") // разрешить с любых источников
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // какие методы разрешены
                        .allowedHeaders("*"); // какие заголовки разрешены
            }
        };
    }
}
