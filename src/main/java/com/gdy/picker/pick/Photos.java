package com.gdy.picker.pick;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("照片信息")
public class Photos {

    @ApiModelProperty(value = "照片总数")
    private Long total;
    @ApiModelProperty(value = "总页数")
    private Long total_pages;

    private String resultsList;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Long total_pages) {
        this.total_pages = total_pages;
    }

    public String getResultsList() {
        return resultsList;
    }

    public void setResultsList(String resultsList) {
        this.resultsList = resultsList;
    }
}
