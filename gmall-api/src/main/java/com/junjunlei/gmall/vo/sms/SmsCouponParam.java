package com.junjunlei.gmall.vo.sms;


import com.junjunlei.gmall.sms.entity.Coupon;
import com.junjunlei.gmall.sms.entity.CouponProductCategoryRelation;
import com.junjunlei.gmall.sms.entity.CouponProductRelation;
import lombok.Data;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 */
@Data
public class SmsCouponParam extends Coupon {
    //优惠券绑定的商品
    private List<CouponProductRelation> productRelationList;
    //优惠券绑定的商品分类
    private List<CouponProductCategoryRelation> productCategoryRelationList;

}
