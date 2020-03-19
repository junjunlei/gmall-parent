package com.junjunlei.gmall.pms.mapper;

import com.junjunlei.gmall.pms.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junjunlei.gmall.pms.vo.ProductCategoryWithChildrenVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {


    /**
     *  商品分类及其子分类
     * @param parentId 父类id
     * @return 商品分类及子类集合
     */
    List<ProductCategoryWithChildrenVO> selectCategoryListWithChildren(@Param("parentId") Long parentId);

    ProductCategoryWithChildrenVO getPms();
}
