package com.junjunlei.gmall.ums.service;

import com.junjunlei.gmall.ums.entity.MemberLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
public interface MemberLevelService extends IService<MemberLevel> {

    /**
     * 获取会员等级列表
     * @return
     */
    List<MemberLevel> getUmsMemberLevelList();
}
