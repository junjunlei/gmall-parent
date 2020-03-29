package com.junjunlei.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.ums.entity.MemberLevel;
import com.junjunlei.gmall.ums.mapper.MemberLevelMapper;
import com.junjunlei.gmall.ums.service.MemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Component
@Service(version = "1.0")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {

    @Autowired
    MemberLevelMapper memberLevelMapper;
    @Override
    public List<MemberLevel> getUmsMemberLevelList() {
        QueryWrapper<MemberLevel> queryWrapper=new QueryWrapper<>();
        List<MemberLevel> list = memberLevelMapper.selectList(queryWrapper);
        return list;
    }
}
