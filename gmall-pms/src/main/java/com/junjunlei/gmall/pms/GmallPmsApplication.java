package com.junjunlei.gmall.pms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 商品管理系统启动类
 *
 *
 * @author junjun.lei
 * @create 2020-03-18 19:58
 */
@MapperScan(basePackages = "com.junjunlei.gmall.pms.mapper")
@EnableDubbo
@SpringBootApplication
public class GmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallPmsApplication.class, args);
    }

}
