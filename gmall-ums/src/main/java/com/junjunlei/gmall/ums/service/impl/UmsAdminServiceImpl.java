package com.junjunlei.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjunlei.gmall.ums.entity.Admin;
import com.junjunlei.gmall.ums.mapper.AdminMapper;
import com.junjunlei.gmall.ums.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Component
@Service(version = "1.0")
public class UmsAdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements UmsAdminService {

    @Autowired
    AdminMapper adminMapper;
    /***
     * 后台用户登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Admin login(String userName, String password) {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        QueryWrapper<Admin> adminWrapper = new QueryWrapper<>();
        adminWrapper.eq("username",userName).eq("password",md5Password);
        Admin admin = adminMapper.selectOne(adminWrapper);
        return admin;
    }

    @Override
    public Admin getUserInfo(String userName) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",userName));
    }
}
