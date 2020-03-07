package com.junjunlei.gmall.oms;

import com.junjunlei.gmall.oms.entity.Order;
import com.junjunlei.gmall.oms.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallOmsApplicationTests {

    @Autowired
    private OrderService orderService;
    @Test
    public void contextLoads() {
        Order order = orderService.getById(26);
        System.out.println(order.getNote());
    }

}
