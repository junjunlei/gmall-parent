package com.junjunlei.gmall.ums.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.junjunlei.gmall.config.SwaggerApiConfig;
import com.junjunlei.gmall.ums.dto.UmsAdminLoginDTO;
import com.junjunlei.gmall.ums.entity.Admin;
import com.junjunlei.gmall.ums.service.UmsAdminService;
import com.junjunlei.gmall.utils.CommonException;
import com.junjunlei.gmall.utils.CommonResult;
import com.junjunlei.gmall.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Api(tags = SwaggerApiConfig.UMS_ADMIN_CONTROLLER)
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class UmsAdminController {

    @Reference(version = "1.0")
    UmsAdminService umsAdminService;
    @Value("${gmall.jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${gmall.jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public Object login(@RequestBody UmsAdminLoginDTO queryParam) {
        Admin login = umsAdminService.login(queryParam.getUserName(), queryParam.getPassword());
        //登陆成功生成token，此token携带基本用户信息，以后就不用去数据库了
        String token = jwtTokenUtil.generateToken(login);
        if (token == null) {
          //return  Results.invalid();
          return new CommonException("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return new CommonResult().success(tokenMap);
    }
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/info")
    public Object getAdminInfo(HttpServletRequest request){
        String  oldToken = request.getHeader(tokenHeader);
        String userName=jwtTokenUtil.getUserNameFromToken(oldToken.substring(tokenHead.length()));
        Admin umsAdmin = umsAdminService.getUserInfo(userName);
        Map<String, Object> data = new HashMap<>(3);
        data.put("username", umsAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("icon", umsAdmin.getIcon());
        return new CommonResult().success(data);
    }
}
