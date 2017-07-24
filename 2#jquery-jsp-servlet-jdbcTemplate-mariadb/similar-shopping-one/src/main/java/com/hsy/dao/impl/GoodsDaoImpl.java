package com.hsy.dao.impl;

import com.hsy.dao.IGoodsDao;
import com.hsy.entity.Goods;
import com.hsy.util.Constant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p>商品数据访问层</p>
 * @date 2017/7/21 14:37
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements IGoodsDao {
    @Override
    public List<Goods> selectList(Integer currentPage,Integer pageSize) {
        if(currentPage <= 1) currentPage = 1;
        StringBuilder sql = new StringBuilder("select id,name,price,number from t_goods") ;
        long countAll = Long.parseLong(String.valueOf(super.jdbcTemplate.queryForList("select count(ccc.id) as countAll from ("+sql.toString()+") ccc").get(0).get("countAll"))) ;
        Constant.requestThreadLocal.get().setAttribute("totalCount",countAll);
        if(currentPage>0&&pageSize>0){
            sql.append(" limit ").append((currentPage-1) * pageSize).append(" , ").append(pageSize) ;
        }
        List<Goods> goodsList = new ArrayList<>();
        super.jdbcTemplate.query(sql.toString(),new RowCallbackHandler(){
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                goodsList.add(new Goods(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getInt("number"))) ;
            }
        });
        return goodsList;
    }

    @Override
    public List<Goods> selectList(Goods goods, Integer currentPage, Integer pageSize) {
       /* String sql = "select id,name,price,number from t_goods where id = ?" ;
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);
        super.jdbcTemplate.query()*/
        return null ;
    }

    @Override
    public Goods getById(Integer id) {
        String sql = "select id,name,price,number from t_goods where id = ?" ;
        RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<>(Goods.class);
        return super.jdbcTemplate.queryForObject(sql,rowMapper,id) ;
    }
}
