package com.hsy.bean.entity;

import java.util.Date;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.bean.entity
 * @date 23/08/2017 2:50 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Log {
    private Long id ;
    private String requestUrl ;
    private Long userId ;
    private String requestAction ;
    private String timing ;
    private String requestMethodType ;
    private String requestParam ;
    private String requestIp;
    private String userRemark ;
    private String requestAddress ;
    private Date requestTime ;
    private String requestResponse ;//请求返回结果

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRequestAction() {
        return requestAction;
    }

    public void setRequestAction(String requestAction) {
        this.requestAction = requestAction;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRequestMethodType() {
        return requestMethodType;
    }

    public void setRequestMethodType(String requestMethodType) {
        this.requestMethodType = requestMethodType;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(String requestResponse) {
        this.requestResponse = requestResponse;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", requestUrl='" + requestUrl + '\'' +
                ", userId=" + userId +
                ", requestAction='" + requestAction + '\'' +
                ", timing='" + timing + '\'' +
                ", requestMethodType='" + requestMethodType + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", userRemark='" + userRemark + '\'' +
                ", requestAddress='" + requestAddress + '\'' +
                ", requestTime=" + requestTime +
                ", requestResponse='" + requestResponse + '\'' +
                '}';
    }
}
