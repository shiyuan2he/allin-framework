package com.hsy.service.impl;

import com.hsy.bean.entity.User;
import com.hsy.dao.IUserDao;
import com.hsy.javase.secure.Base64Helper;
import com.hsy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsy.cache.RedisCache ;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private RedisCache redisCache;
    public boolean register(String name, String password, Long tel, String sex) {
        try{
            User user = new User() ;
            user.setName(name);
            user.setPassword(Base64Helper.stringToBase64(password));
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

    @Override
    public List<User> getUserList(Integer beginIndex, Integer querySize) {
        String cache_key=RedisCache.CAHCENAME+"list:user:"+beginIndex+"_"+querySize;
        List<User> userList_cache = redisCache.getListCache(cache_key,User.class) ;
        if(null!=userList_cache&&userList_cache.size()>0){
            _logger.info("从缓存中获取key={}",cache_key);
            return userList_cache ;
        }else{
            List<User> list = iUserDao.getAllUsers(beginIndex,querySize);
            for(User user : list){
                user.setPassword(Base64Helper.base64ToString(user.getPassword()));
            }
            redisCache.putListCacheWithExpireTime(cache_key,list,RedisCache.CAHCETIME) ;
            _logger.info("将key={}放入缓存中，时效60分钟",cache_key);
            return list;
        }
    }
}
