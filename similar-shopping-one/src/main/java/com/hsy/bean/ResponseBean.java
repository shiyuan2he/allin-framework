package com.hsy.bean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/22 14:40
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class ResponseBean {
    private String code ;
    private String msg ;
    private Object data ;
    private Integer currentPage ;
    private Integer defaultPageSize;
    private Integer pageSize ;
    private Long totalCount ;

    public ResponseBean(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBean(String code, String msg, Object data, Integer currentPage, Integer pageSize, Long totalCount) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getDefaultPageSize() {
        defaultPageSize = 10 ;
        return defaultPageSize;
    }
    public void setDefaultPageSize(Integer defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
