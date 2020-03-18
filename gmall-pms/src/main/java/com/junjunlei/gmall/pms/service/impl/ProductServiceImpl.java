package com.junjunlei.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.page.PageInfoVO;
import com.junjunlei.gmall.pms.dto.ProductDTO;
import com.junjunlei.gmall.pms.entity.Product;
import com.junjunlei.gmall.pms.mapper.ProductMapper;
import com.junjunlei.gmall.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Component
@Service(version = "1.0")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public PageInfoVO getProductList(ProductDTO param) {
        Page<Product> page = new Page<>(param.getPageNum(),param.getPageSize());
        IPage<Product> productIPage = productMapper.selectPage(page, null);
        PageInfoVO pageInfoVO=new PageInfoVO(productIPage.getTotal(),productIPage.getPages(),productIPage.getSize(),productIPage.getRecords()
        ,productIPage.getCurrent());
        return pageInfoVO;
    }
}
