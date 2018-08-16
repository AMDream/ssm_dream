package com.dream.serviceImpl;

import com.dream.service.RedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class RedisTemplateServiceImpl implements RedisTemplateService {
    @Autowired
    private RedisTemplate redisTemplate = null;

    @Override
    public void execMultiCommand() {
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                ops.boundValueOps("key1").set("abc1");
                ops.boundHashOps("hash").put("hash_key_1","hash_value_1");
                return ops.boundValueOps("key1").get();
            }
        };
        Object obj = redisTemplate.execute(callback);
        System.out.println(obj);
    }

    @Override
    public void execTransaction() {
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                //监控
                ops.watch("key1");
                //开启事务
                ops.multi();
                ops.boundValueOps("key2").set("abc2");
                ops.boundHashOps("hash").put("hash_key_2","hash_value_2");
                ops.opsForValue().get("key2");
                //执行exec方法后触发事务执行，返回结果，放到list中
                List result = ops.exec();
                return result;
            }
        };
        List list = (List) redisTemplate.execute(callback);
        System.out.println(list);
    }

    @Override
    public void execPipeLine() {
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                ops.opsForValue().set("key3","value3");
                ops.opsForHash().put("hash","hash_key_3","hash_value_3");
                return ops.opsForValue().get("key3");
            }
        };
        List list = redisTemplate.executePipelined(callback);
        System.out.println(list);
    }
}
