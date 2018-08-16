package com.dream.others;

import com.dream.config.ApplicationConfig;
import com.dream.pojo.Role;
import com.dream.pojo.RoleRedis;
import com.dream.service.RoleListService;
import com.dream.service.RoleService;
import com.dream.serviceImpl.RoleCacheServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static byte[] getFileToByte(File file){
        byte[] by = new byte[(int) file.length()];
        try{
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1){
                os.write(bb,0,ch);
                ch = is.read(bb);
            }
            by = os.toByteArray();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return by;
    }
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleService rs = (RoleService) ac.getBean("roleCache");
        Role rr = rs.getRoleById(1);
        System.out.println("耿巧梦："+rr);
        Role role = new Role();
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        rs.insertRole(role);
        System.out.println("Dream:"+role);
        int id = role.getId();
        Role pp = rs.getRoleById(id);
        System.out.println(pp);
        rs.deleteRole(id);
        /*
        执行Lua脚本
        RedisTemplate rt = ac.getBean(RedisTemplate.class);
        File file = new File("C:\\Users\\Dream\\Downloads\\Redis-x64-3.2.100\\test.lua");
        byte[] bytes = getFileToByte(file);
        Jedis jedis = (Jedis) rt.getConnectionFactory().getConnection().getNativeConnection();
        byte[] sha1 = jedis.scriptLoad(bytes);
        Object obj = jedis.evalsha(sha1,2,"key1".getBytes(),"key2".getBytes(),"2".getBytes(),"4".getBytes());
        System.out.println(obj);*/
        /*
        发布订阅模式
        String channel = "chat";
        rt.convertAndSend(channel,"I am lazy!");*/
        /*SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    int j = i+1;
                    ops.boundValueOps("pipeline_key_"+j).set("pipeline_value_"+j);
                    ops.boundValueOps("pipeline_key_"+j).get();
                }
                return null;
            }
        };
        Long begin = System.currentTimeMillis();
        List result = rt.executePipelined(callback);
        Long end = System.currentTimeMillis();
        System.out.println(end-begin);*/
        /*final RoleRedis rr = new RoleRedis();
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
        System.out.println(rs);*/
    }
}
