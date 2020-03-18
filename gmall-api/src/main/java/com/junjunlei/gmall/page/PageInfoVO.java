package com.junjunlei.gmall.page;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息封装
 *
 * @author junjun.lei
 * @create 2020-03-18 17:58
 */
public class PageInfoVO implements Serializable {

    @ApiModelProperty("总记录数")
    private Long total;
    @ApiModelProperty("总页数")
    private Long totalPage;
    @ApiModelProperty("每页显示记录数")
    private Long pageSize;
    @ApiModelProperty("分页数据")
    private List<? extends Object> list;
    @ApiModelProperty("当前页")
    private Long pageNum;

    public PageInfoVO(Long total, Long totalPage, Long pageSize, List<? extends Object> list, Long pageNum) {
        this.total = total;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.list = list;
        this.pageNum = pageNum;
    }

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public List<? extends Object> getList() {
        return list;
    }

    public void setList(List<? extends Object> list) {
        this.list = list;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PageInfoVO{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", pageNum=" + pageNum +
                '}';
    }
}
