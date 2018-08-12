package com.dream.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.dream.controller"})
@ImportResource(value = "classpath:spring-mvc.xml")
@EnableWebMvc   //启用Spring mvc
public class WebConfig {
}
