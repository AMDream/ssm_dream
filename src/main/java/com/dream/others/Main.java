package com.dream.others;

import com.dream.config.ApplicationConfig;
import com.dream.pojo.Role;
import com.dream.pojo.RoleRedis;
import com.dream.service.RoleListService;
import com.dream.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final RoleRedis rr = new RoleRedis();
        rr.setId(1);
        rr.setNote("redis_note");
        rr.setRoleName("redis_name");
        RedisTemplate rt = ac.getBean(RedisTemplate.class);
        //使用SessionCallBack保证在同一个连接池的同一个Redis连接进行操作
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                ops.boundValueOps("role_1").set(rr);
                return (RoleRedis)ops.boundValueOps("role_1").get();
            }
        };
        RoleRedis rs = (RoleRedis) rt.execute(callback);
        System.out.println(rs);
    }
}
