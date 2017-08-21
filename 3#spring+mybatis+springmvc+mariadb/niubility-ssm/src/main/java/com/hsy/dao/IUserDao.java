package com.hsy.dao;

import com.hsy.bean.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao
 * @date 17/08/2017 5:54 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IUserDao {

    void saveUser(User user) ;
    /**
     * @description <p></p>
     * @param beginIndex 查询其实行数
     * @param querySize  每页显示数量
     * @return List<User> 返回结果集
     * @author heshiyuan 
     * @date 18/08/2017 10:31 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    List<User> getAllUsers(Integer beginIndex,Integer querySize);
    /**
     * @description <p>根据主键获取对象</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 9:00 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    User getUserById(long id) ;
    /**
     * @description <p>根据对象参数获取对象</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 9:00 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    User getUserByParam(User user) ;
    /**
     * @description <p>增加积分</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 8:59 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    Integer addScore(@Param("score") int score) ;
}
