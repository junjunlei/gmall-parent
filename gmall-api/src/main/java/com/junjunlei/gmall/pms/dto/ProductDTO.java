package com.junjunlei.gmall.pms.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 商品信息DTO
 *
 * @author junjun.lei
 * @create 2020-03-18 19:33
 */
public class ProductDTO implements Serializable {

    @ApiModelProperty("上架状态")
    private Integer publishStatus;
    @ApiModelProperty("审核状态")
    private Integer verifyStatus;
    @ApiModelProperty("商品名称模糊关键字")
    private String keyword;
    @ApiModelProperty("商品货号")
    private String productSn;
    @ApiModelProperty("商品分类编号")
    private Long productCategoryId;
    @ApiModelProperty("商品品牌编号")
    private Long brandId;
    @ApiModelProperty("每页显示记录数")
    private Long pageSize=5L;
    @ApiModelProperty("当前页数")
    private Long pageNum=1L;

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        if (pageSize == null) {
            //默认每页显示条数据
            pageSize = 5L;
        }
        this.pageSize = pageSize;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        if (pageNum == null) {
            //默认第一页
            pageNum = 1L;
        }
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "publishStatus=" + publishStatus +
                ", verifyStatus=" + verifyStatus +
                ", keyword='" + keyword + '\'' +
                ", productSn='" + productSn + '\'' +
                ", productCategoryId=" + productCategoryId +
                ", brandId=" + brandId +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }
}
