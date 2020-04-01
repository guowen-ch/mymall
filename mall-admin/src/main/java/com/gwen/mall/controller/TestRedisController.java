package com.gwen.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.gwen.mall.dto.User;
import com.gwen.mall.redis.redisservice.IRedisService;
import com.gwen.mall.redis.shiro.RedisCache;
import com.gwen.mall.redis.shiro.RedisCacheManager;
import com.gwen.mall.redis.shiro.RedisManager;
import com.gwen.mall.redis.shiro.SerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Description：
 * Created By guowen
 */
@RestController
public class TestRedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IRedisService redisService;
    @Autowired
    private RedisManager redisManager;


    @RequestMapping("/test")
    public void test() throws Exception {
        User user=new User();
        user.setUserId(1L);
        user.setUserName("test");
        redisManager.set("user1".getBytes(), SerializeUtils.serialize(user),10);
        System.out.println("redissetvalue");
    }

    @RequestMapping("/flushDB")
    public void flushDB() throws Exception {
        byte[] u = redisManager.get("user1".getBytes());
        User user=(User)SerializeUtils.deserialize(u);
        System.out.println(JSONObject.toJSON(user));
        User user3 =  (User)redisService.getValue("user1");
        System.out.println(JSONObject.toJSON(user3));
        redisManager.flushDB();
    }
    @RequestMapping("/dbSize")
    public void dbSize() throws Exception {
        Long size = redisManager.dbSize();
        System.out.println("size="+size);
    }
    @RequestMapping("/test2")
    public void testObj() throws Exception {
        User user=new User();
        user.setUserId(1L);
        user.setUserName("test");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("user1", user);
        operations.set("user2", user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        User user3 =  (User)redisService.getValue("user1");
        System.out.println(JSONObject.toJSON(user3));
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("user2");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }
    @RequestMapping("/getUser")
    @Cacheable(value="user1")//value 的值就是缓存到 Redis 中的 key
    public User getUser(@RequestBody User u) {
        User user=new User();
        user.setUserId(1L);
        user.setUserName("test");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
}
