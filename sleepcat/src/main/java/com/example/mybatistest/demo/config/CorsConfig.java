package com.example.mybatistest.demo.config;

import com.example.mybatistest.demo.service.CustomCorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean customCorsfilterRegistrationBean() {
        FilterRegistrationBean<CustomCorsFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomCorsFilter());
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}