package com.junnjunlei.locks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 并发锁测试
 * @author junjun.lei
 * @create 2020-03-29 19:17
 */
@Service
public class LockService {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 数据自增
     */
    public synchronized void incr() {
        //默认设为0
        String num = redisTemplate.opsForValue().get("num");
        if(num!=null){
            Integer number = Integer.valueOf(num);
            number++;
            redisTemplate.opsForValue().set("num",number.toString());
        }
    }

    /**
     * 自定义分布式锁
     */
    public void distributeIncr(){
        String token= UUID.randomUUID().toString();
        //锁的key lock  锁的归属者 token 超时时间 3s
        Boolean lock=redisTemplate.opsForValue().setIfAbsent("lock",token,3, TimeUnit.SECONDS);
        if(lock){
            //默认设为0
            String num = redisTemplate.opsForValue().get("num");
            if(num!=null){
                Integer number = Integer.valueOf(num);
                number++;
                redisTemplate.opsForValue().set("num",number.toString());
            }
            //删除锁

            //lua脚本
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            DefaultRedisScript<Boolean> script1 = new DefaultRedisScript<>(script,Boolean.class);
            redisTemplate.execute(script1, Arrays.asList("lock"),token);
            System.out.println("删除锁ok");
        }else {
            //自旋
            distributeIncr();
        }

    }
}
