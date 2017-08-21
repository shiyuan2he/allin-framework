package com.hsy.service.impl;

import com.hsy.bean.entity.User;
import com.hsy.dao.IUserDao;
import com.hsy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.service.impl
 * @date 18/08/2017 10:40 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    private final static Logger _logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    IUserDao iUserDao ;
    @Override
    public boolean register(String name, String password, Long tel, char sex) {
        try{
            User user = new User() ;
            user.setName(name);
            user.setPassword(password);
            user.setTel(tel);
            user.setCreateTime(new Date());
            user.setSex(sex);
            iUserDao.saveUser(user);
            return true ;
        }catch(Exception e){
            _logger.error("【注册】添加数据报错，异常信息：{}",e.getMessage());
            return false ;
        }
    }

    @Override
    public boolean login(Long tel, String password) {
        try{
            User user = new User() ;
            user.setPassword(password);
            user.setTel(tel);
            iUserDao.getUserByParam(user) ;
            return true ;
        }catch(Exception e){
            _logger.error("【登陆】查询数据报错，异常信息：{}",e.getMessage());
            return false ;
        }
    }
}
