package com.junjunlei.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.pms.entity.ProductCategory;
import com.junjunlei.gmall.pms.mapper.ProductCategoryMapper;
import com.junjunlei.gmall.pms.service.ProductCategoryService;
import com.junjunlei.gmall.pms.vo.ProductCategoryWithChildrenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Component
@Service(version = "1.0")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategoryWithChildrenVO> getCategoryList(Long parentId) {
        return productCategoryMapper.selectCategoryListWithChildren(parentId);
    }
}
