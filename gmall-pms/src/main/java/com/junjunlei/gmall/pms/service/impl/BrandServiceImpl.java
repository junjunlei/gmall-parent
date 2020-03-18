package com.junjunlei.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.page.PageInfoVO;
import com.junjunlei.gmall.pms.entity.Brand;
import com.junjunlei.gmall.pms.mapper.BrandMapper;
import com.junjunlei.gmall.pms.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Component
@Service(version = "1.0")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    BrandMapper brandMapper;
    @Override
    public PageInfoVO getBrandList(String keyword, Long pageNum, Long pageSize) {
        QueryWrapper<Brand> wrapper =null;
        if(StringUtils.isNotEmpty(keyword)) {
            wrapper= new QueryWrapper<>();
            wrapper.like("name", keyword);
        }
        IPage<Brand> page = brandMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return new PageInfoVO(page.getTotal(),page.getPages(),page.getSize(),page.getRecords(),page.getCurrent());
    }
}
