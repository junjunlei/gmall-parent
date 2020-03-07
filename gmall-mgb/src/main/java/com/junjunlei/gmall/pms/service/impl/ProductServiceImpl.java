package com.junjunlei.gmall.pms.service.impl;

import com.junjunlei.gmall.pms.entity.Product;
import com.junjunlei.gmall.pms.mapper.ProductMapper;
import com.junjunlei.gmall.pms.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
