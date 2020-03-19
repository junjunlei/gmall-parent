package com.junjunlei.gmall.ums.service;

import com.junjunlei.gmall.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
public interface UmsAdminService extends IService<Admin> {
    /**
     * 后台用户登录
     * @param userName
     * @param password
     * @return
     */
    Admin login(String userName,String password);

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    Admin getUserInfo(String userName);
}
