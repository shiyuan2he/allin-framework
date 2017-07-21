package com.hsy.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
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
@Repository("baseDao")
public class BaseDaoImpl<T>{
    Class<T> classType ;
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public T getByIdOfSuper(String sql,Integer id) {
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(classType);
        return jdbcTemplate.queryForObject(sql,rowMapper,id) ;
    }

    public List<T> selectListOfSuper(String sql,Object[] paramObj){
        //RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(classType);
        return jdbcTemplate.queryForList(sql,classType,paramObj) ;
    }
}
