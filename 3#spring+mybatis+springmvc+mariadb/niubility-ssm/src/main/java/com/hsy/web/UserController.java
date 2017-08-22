package com.hsy.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hsy.bean.entity.User;
import com.hsy.dto.RequestBodyBean;
import com.hsy.dto.ResponseBodyBean;
import com.hsy.service.IUserService;
import com.hsy.utils.BusinessUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.web
 * @date 18/08/2017 10:50 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    private final static Logger _logger = LoggerFactory.getLogger(UserController.class) ;

    @Autowired
    private IUserService userService ;

    @RequestMapping("/register.do")
    public @ResponseBody ResponseBodyBean<Object> register(@RequestBody String json, HttpSession session){
        _logger.info("进入 /user/register.do ...");
        RequestBodyBean requestBody =  JSON.parseObject(json,new TypeReference<RequestBodyBean>(){}) ;
        User user = requestBody.getUser() ;
        //User user = BusinessUtils.requestJsonToBean(json,User.class) ;
        if(BusinessUtils.validateParamForRegister(user)){
            boolean flag = userService.register(user.getName(),user.getPassword(),user.getTel(),user.getSex());
            if(flag){
                return super.success() ;
            }
        }
        _logger.info("退出 /user/register.do ...");
        return super.failure() ;
    }
    @RequestMapping("/login.do")
    public @ResponseBody ResponseBodyBean<Object> login(@RequestBody String json, HttpSession session){
        _logger.info("进入 /user/login.do ...");
        RequestBodyBean requestBody =  JSON.parseObject(json,new TypeReference<RequestBodyBean>(){}) ;
        User user = requestBody.getUser() ;
        //User user = BusinessUtils.requestJsonToBean(json,User.class) ;
        boolean flag = userService.login(user.getTel(),user.getPassword());
        if(flag){
            return super.success() ;
        }
        _logger.info("退出 /user/login.do ...");
        return super.failure() ;
    }
    @RequestMapping("/list.do")
    public @ResponseBody ResponseBodyBean<Object> list(@RequestBody String json, HttpSession session){
        _logger.info("进入 /user/list.do ...");
        List<User> list = userService.getUserList(1,4);
        if(list.size()>0){
            return super.success(list) ;
        }
        _logger.info("退出 /user/list.do ...");
        return super.failure("没有查询到数据") ;
    }
}
