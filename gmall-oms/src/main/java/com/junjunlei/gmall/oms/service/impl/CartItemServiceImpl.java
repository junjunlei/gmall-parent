package com.junjunlei.gmall.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.oms.entity.CartItem;
import com.junjunlei.gmall.oms.mapper.CartItemMapper;
import com.junjunlei.gmall.oms.service.CartItemService;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Component
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

}
