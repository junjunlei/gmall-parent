package com.junjunlei.gmall.oms.service.impl;

import com.junjunlei.gmall.oms.entity.Order;
import com.junjunlei.gmall.oms.mapper.OrderMapper;
import com.junjunlei.gmall.oms.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
