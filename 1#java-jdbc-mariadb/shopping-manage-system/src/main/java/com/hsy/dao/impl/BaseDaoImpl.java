package com.hsy.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao.impl
 * @date 2017/7/16 下午2:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BaseDaoImpl<T,ID> {
    protected Connection conn = null ;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    List<T> selectList(T t){
        try {
            Class<?> clazz = Class.forName("com.hsy.entity.Salesperson");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
