package com.junjunlei.gmall.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.junjunlei.gmall.config.SwaggerApiConfig;
import com.junjunlei.gmall.page.PageInfoVO;
import com.junjunlei.gmall.pms.dto.ProductDTO;
import com.junjunlei.gmall.pms.service.ProductService;
import com.junjunlei.gmall.utils.CommonResult;
import com.junjunlei.gmall.vo.product.PmsProductParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 *
 * @author junjun.lei
 * @create 2020-03-18 17:59
 */
@CrossOrigin
@RestController
@Api(tags = SwaggerApiConfig.PMS_PRODUCT_CONTROLLER)
@RequestMapping("/product")
@Slf4j
public class PmsProductController {
    @Reference(version = "1.0")
    ProductService productService;

    @ApiOperation("创建商品")
    @PostMapping(value = "/create")
    public Object create(@RequestBody PmsProductParam productParam) {

        log.debug("将要保存的商品数据是：{}",productParam);


        log.debug("当前线程....{}-->{}",Thread.currentThread().getId(),Thread.currentThread().getName());
       // productService.saveProduct(productParam);
        return new CommonResult().success(null);
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @GetMapping(value = "/updateInfo/{id}")
    public Object getUpdateInfo(@PathVariable Long id) {
        //TODO 根据商品id获取商品编辑信息
        return new CommonResult().success(null);
    }

    @ApiOperation("更新商品")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable Long id, @RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        //TODO 更新商品
        return new CommonResult().success(null);
    }

    @ApiOperation("查询商品")
    @GetMapping(value = "/list")
    public Object getProductList(ProductDTO queryParam) {
        //TODO 查询商品

        PageInfoVO pageInfoVO =  productService.getProductList(queryParam);

        return new CommonResult().success(pageInfoVO);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @GetMapping(value = "/simpleList")
    public Object getList(String  keyword) {
        //TODO 根据商品名称或货号模糊查询
        return new CommonResult().success(null);
    }

    @ApiOperation("批量修改审核状态")
    @PostMapping(value = "/update/verifyStatus")
    public Object updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("verifyStatus") Integer verifyStatus,
                                     @RequestParam("detail") String detail) {
        //TODO 批量修改审核状态
        return new CommonResult().success(null);
    }

    @ApiOperation("批量上下架")
    @PostMapping(value = "/update/publishStatus")
    public Object updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("publishStatus") Integer publishStatus) {
        //TODO 批量上下架
        return new CommonResult().success(null);
    }

    @ApiOperation("批量推荐商品")
    @PostMapping(value = "/update/recommendStatus")
    public Object updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("recommendStatus") Integer recommendStatus) {
        //TODO 批量推荐商品
        return new CommonResult().success(null);
    }

    @ApiOperation("批量设为新品")
    @PostMapping(value = "/update/newStatus")
    public Object updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus) {
        //TODO 批量设为新品
        return new CommonResult().success(null);
    }

    @ApiOperation("批量修改删除状态")
    @PostMapping(value = "/update/deleteStatus")
    public Object updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("deleteStatus") Integer deleteStatus) {
        //TODO 根据商品id获取商品编辑信息
        return new CommonResult().success(null);
    }
}
