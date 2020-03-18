package com.junjunlei.gmall.pms.service;

import com.junjunlei.gmall.page.PageInfoVO;
import com.junjunlei.gmall.pms.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
public interface BrandService extends IService<Brand> {
    /**
     * 分页查询品牌列表
     * @param keyword 关键字
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    PageInfoVO getBrandList(String keyword, Long pageNum, Long pageSize);
}
