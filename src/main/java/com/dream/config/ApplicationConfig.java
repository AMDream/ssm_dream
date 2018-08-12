package com.dream.config;

import com.dream.aspect.RoleAspect;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */
@Configuration
@EnableAspectJAutoProxy  //自动代理
@EnableTransactionManagement  //开启事务管理
@ComponentScan(basePackages = {"com.dream.controller","com.dream.mapper","com.dream.serviceImpl"})
@ImportResource("classpath:spring-dao.xml")
public class ApplicationConfig {
    //生成切面实例
    /*@Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }*/
}
