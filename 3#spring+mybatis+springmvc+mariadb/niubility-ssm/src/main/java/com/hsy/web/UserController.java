package com.hsy.web;

import com.alibaba.fastjson.JSON;
import com.hsy.annotation.AspectJLogAnnotation;
import com.hsy.bean.entity.User;
import com.hsy.bean.javabean.LoginParam;
import com.hsy.bean.javabean.RegisterParam;
import com.hsy.dto.RequestBodyBean;
import com.hsy.dto.ResponseBodyBean;
import com.hsy.enums.ConstantsEnum;
import com.hsy.service.IUserService;
import com.hsy.utils.BusinessUtils;
import com.hsy.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @AspectJLogAnnotation(saveToDb=true,description = "注册")
    @RequestMapping("/register.do")
    public @ResponseBody ResponseBodyBean<Object> register(@RequestBody String json, HttpSession session){
        _logger.info("进入 /user/register.do ...");
        RegisterParam registerParam = BusinessUtils.requestJsonToBean(json,RegisterParam.class) ;
        if(BusinessUtils.validateParamForRegister(registerParam)){
            boolean flag = userService.register(registerParam.getName(),registerParam.getPassword(),registerParam.getTel(),registerParam.getSex());
            if(flag){
                return super.success() ;
            }
        }
        _logger.info("退出 /user/register.do ...");
        return super.failure() ;
    }
    @AspectJLogAnnotation(saveToDb=true,description = "登陆")
    @RequestMapping("/login.do")
    public @ResponseBody ResponseBodyBean<Object> login(@RequestBody String json,HttpServletRequest request,HttpServletResponse response){
        Constants.requestThreadLocal = new ThreadLocal<HttpServletRequest>(){
            @Override
            protected HttpServletRequest initialValue() {
                return request ;
            }
        };
        Constants.responseThreadLocal =  new ThreadLocal<HttpServletResponse>(){
            @Override
            protected HttpServletResponse initialValue() {
                return response ;
            }
        };
        _logger.info("进入 /user/login.do ...");
        LoginParam login = BusinessUtils.requestJsonToBean(json,LoginParam.class) ;
        if(null!=login){
            boolean flag = userService.login(login.getTel(),login.getPassword());
            if(flag){
                return super.success() ;
            }
        }
        _logger.info("退出 /user/login.do ...");
        return super.failure() ;
    }

    @RequestMapping("/list.do")
    @AspectJLogAnnotation(saveToDb=true,description = "查询")
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
