package com.junjunlei.gmall.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.junjunlei.gmall.config.SwaggerApiConfig;
import com.junjunlei.gmall.ums.entity.MemberLevel;
import com.junjunlei.gmall.ums.service.MemberLevelService;
import com.junjunlei.gmall.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author junjun.lei
 * @create 2020-03-21 2:04
 */
@CrossOrigin
@Api(tags = SwaggerApiConfig.UMS_MEMBER_LEVEL_CONTROLLER)
@RestController
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {

    @Reference(version = "1.0")
    MemberLevelService memberLevelService;

    @ApiOperation("获取会员等级列表")
    @GetMapping("/list")
    public Object getUmsMemberLevelList(){
        List<MemberLevel> list=memberLevelService.getUmsMemberLevelList();
        return new CommonResult().success(list);
    }
}
