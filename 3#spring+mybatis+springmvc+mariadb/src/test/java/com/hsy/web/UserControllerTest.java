package com.hsy.web;

import com.hsy.JUnit4ControllerBase;
import com.hsy.bean.entity.User;
import com.hsy.bean.javabean.LoginParam;
import com.hsy.bean.javabean.RegisterParam;
import com.hsy.dto.RequestBodyBean;
import com.hsy.javase.utils.MathHelper;
import com.hsy.utils.BusinessUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.web
 * @date 21/08/2017 9:12 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class UserControllerTest extends JUnit4ControllerBase {
    private final static Logger _logger = LoggerFactory.getLogger(UserControllerTest.class) ;
    @Test
    public void testRegister(){
        RequestBodyBean<RegisterParam> requestJson = new RequestBodyBean<>() ;
        RegisterParam user = new RegisterParam() ;
        user.setName("何大大一");
        user.setPassword("aa1234");
        user.setSex("1");
        user.setTel(MathHelper.generateRandomOfLongByLength(11));
        requestJson.setParam(user);
        String requestJsonStr = BusinessUtils.requestBeanToJson(requestJson) ;
        _logger.info("请求json串：{}",requestJsonStr);
        this.postJsonRequest("/user/register.do",requestJsonStr);
    }
    @Test
    public void testLogin(){
        RequestBodyBean<LoginParam> requestJson = new RequestBodyBean<>() ;
        LoginParam login = new LoginParam() ;
        login.setPassword("aa1234");
        login.setTel(26767604315l);
        requestJson.setParam(login);
        String requestJsonStr = BusinessUtils.requestBeanToJson(requestJson) ;
        _logger.info("请求json串：{}",requestJsonStr);
        this.postJsonRequest("/user/login.do",requestJsonStr);
    }
    @Test
    public void testList(){
        RequestBodyBean<User> requestJson = new RequestBodyBean<>() ;
        String requestJsonStr = BusinessUtils.requestBeanToJson(requestJson) ;
        _logger.info("请求json串：{}",requestJsonStr);
        this.postJsonRequest("/user/list.do",requestJsonStr);
    }
}
