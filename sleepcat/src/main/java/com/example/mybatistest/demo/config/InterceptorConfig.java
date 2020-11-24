package com.example.mybatistest.demo.config;

import com.example.mybatistest.demo.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JWTService jwtService;
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor(jwtService);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/logout").excludePathPatterns("/loginSys").excludePathPatterns("/static/**");
    }
}