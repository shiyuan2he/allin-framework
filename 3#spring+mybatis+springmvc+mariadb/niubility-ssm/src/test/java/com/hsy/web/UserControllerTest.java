package com.hsy.web;

import com.hsy.JUnit4ControllerBase;
import com.hsy.bean.entity.User;
import com.hsy.dto.RequestBodyBean;
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
        RequestBodyBean<User> requestJson = new RequestBodyBean<>() ;
        User user = new User() ;
        user.setName("何大大一");
        user.setPassword("123456");
        user.setSex((char) 1);
        user.setTel(15910868635l);
        requestJson.setUser(user);
        String requestJsonStr = BusinessUtils.requestBeanToJson(requestJson) ;
        _logger.info("请求json串：{}",requestJsonStr);
        this.postJsonRequest("/user/register.do",requestJsonStr);
    }
    @Test
    public void testLogin(){
        RequestBodyBean<User> requestJson = new RequestBodyBean<>() ;
        User user = new User() ;
        user.setPassword("123456");
        user.setTel(15910868635l);
        requestJson.setUser(user);
        String requestJsonStr = BusinessUtils.requestBeanToJson(requestJson) ;
        _logger.info("请求json串：{}",requestJsonStr);
        this.postJsonRequest("/user/login.do",requestJsonStr);
    }
}
