package com.dream.config.redisListener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 */
public class RedisMessageListener implements MessageListener {
    private RedisTemplate redisTemplate;
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        String msgBody = (String)getRedisTemplate().getValueSerializer().deserialize(body);
        System.out.println("耿耿："+msgBody);
        byte[] channel = message.getChannel();
        String channelStr = (String)getRedisTemplate().getStringSerializer().deserialize(channel);
        System.out.println("耿耿："+channelStr);
        String str = new String(bytes);
        System.out.println(str);
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
