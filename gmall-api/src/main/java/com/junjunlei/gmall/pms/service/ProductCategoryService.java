package com.junjunlei.gmall.pms.service;

import com.junjunlei.gmall.pms.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjunlei.gmall.pms.vo.ProductCategoryWithChildrenVO;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    /**
     * 获取商品分类集合
     * @param parentId
     * @return 商品分类集合（一级分类、二级分类、三级分类）
     */
    List<ProductCategoryWithChildrenVO> getCategoryList(Long parentId);
}
