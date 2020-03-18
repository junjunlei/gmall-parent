package com.junjunlei.gmall.pms.service;

import com.junjunlei.gmall.page.PageInfoVO;
import com.junjunlei.gmall.pms.dto.ProductDTO;
import com.junjunlei.gmall.pms.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
public interface ProductService extends IService<Product> {
    /**
     * 获取商品分页信息
     * @param param 查询参数
     * @return
     */
    PageInfoVO getProductList(ProductDTO param);
}
