package com.junnjunlei.locks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
}
