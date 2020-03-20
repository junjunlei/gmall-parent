package com.junjunlei.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.constant.Constants;
import com.junjunlei.gmall.pms.entity.ProductCategory;
import com.junjunlei.gmall.pms.mapper.ProductCategoryMapper;
import com.junjunlei.gmall.pms.service.ProductCategoryService;
import com.junjunlei.gmall.pms.vo.ProductCategoryWithChildrenVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
@Slf4j
@Component
@Service(version = "1.0")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Override
    public List<ProductCategoryWithChildrenVO> getCategoryList(Long parentId) {
        //使用redis 优化菜单
        List<ProductCategoryWithChildrenVO> menu= (List<ProductCategoryWithChildrenVO>) redisTemplate.opsForValue().get(Constants.RedisKey.PRODUCT_CATEGORY_ALL);
        if(CollectionUtils.isNotEmpty(menu)){
            log.debug("========================命中菜单数据=======================================================================");
            return menu;
        }else {
            //从数据库查询
            List<ProductCategoryWithChildrenVO> list = productCategoryMapper.selectCategoryListWithChildren(parentId);
            //存入redis
            redisTemplate.opsForValue().set(Constants.RedisKey.PRODUCT_CATEGORY_ALL,list);
            return list;
        }
    }
}
