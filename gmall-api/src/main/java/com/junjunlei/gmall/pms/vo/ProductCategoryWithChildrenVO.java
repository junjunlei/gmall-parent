package com.junjunlei.gmall.pms.vo;

import com.junjunlei.gmall.pms.entity.ProductCategory;

import java.io.Serializable;
import java.util.List;

/**
 * 商品分类递归VO
 * @author junjun.lei
 * @create 2020-03-19 21:32
 */
public class ProductCategoryWithChildrenVO extends ProductCategory implements Serializable {
    /**
     * 下一级分类集合
     */
    private List<ProductCategory> children;

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ProductCategoryWithChildrenVO{" +
                "children=" + children +
                '}';
    }
}
