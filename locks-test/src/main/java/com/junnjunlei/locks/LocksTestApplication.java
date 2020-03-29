package com.junnjunlei.locks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 并发下锁的测试
 * @author junjun.lei
 */
@SpringBootApplication
public class LocksTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocksTestApplication.class, args);
    }

}
