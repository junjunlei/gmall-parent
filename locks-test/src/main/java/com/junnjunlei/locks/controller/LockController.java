package com.junnjunlei.locks.controller;

import com.junnjunlei.locks.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author junjun.lei
 * @create 2020-03-29 19:20
 */
@RestController
public class LockController {

    @Autowired
    LockService lockService;
    @GetMapping("/incr")
    public String incr() {
        lockService.incr();
        return "ok";
    }
}
