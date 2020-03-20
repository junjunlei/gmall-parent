package com.junjunlei.gmall.pms;

import com.junjunlei.gmall.pms.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("hello", "hello");
        String hello = stringRedisTemplate.opsForValue().get("hello");
        System.out.println(hello);
    }

    @Test
    public void stringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("lov", "测试一下");
        String lov = stringRedisTemplate.opsForValue().get("lov");
        System.out.println("《========================================================================》");
        log.info("命中缓存：",lov);
        System.out.println("《========================================================================》");
    }

    @Test
    public void redisTemple(){
        Brand brand=new Brand();
        brand.setName("护肤品");
        redisTemplate.opsForValue().set("brand_key",brand);
        Brand brand_key = (Brand) redisTemplate.opsForValue().get("brand_key");
        log.debug("商品分类========================》",brand_key);
    }
}
