package com.hsy.service;

import com.hsy.bean.entity.User;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.service
 * @date 18/08/2017 10:34 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IUserService {
    /**
     * @description <p>用户注册</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 10:39 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    boolean register(String name,String password,Long tel,String sex) ;
    /**
     * @description <p>用户登陆</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 19/08/2017 3:23 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    boolean login(Long tel,String password) ;
    /**
     * @description <p>用户列表</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 19/08/2017 3:23 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    List<User> getUserList(Integer beginIndex, Integer querySize) ;
}
