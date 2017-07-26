package com.hsy.dao.impl;

import com.hsy.dao.IGoodsSalespersonDao;
import com.hsy.entity.GoodsSalesperson;
import com.hsy.util.DBUtils;
import com.hsy.util.DateUtils;

import java.sql.SQLException;
import java.sql.Time;
import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao.impl
 * @date 2017/7/15 下午6:01
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class GoodsSalespersonDaoImpl extends BaseDaoImpl implements IGoodsSalespersonDao {

    public  List<Map<String,Object>> dailyGsales() {
        List<Map<String,Object>> returnMapList = new ArrayList<>();
        conn = DBUtils.getConnetction();
        String sql = "SELECT" +
                " gs.sales_time as salesTime," +
                " gs.id as id," +
                " g.`name` as goodsName," +
                " s.`name` as salesName," +
                " g.price as price," +
                " gs.number as count," +
                " g.price * g.number as total" +
                " FROM" +
                " t_r_goods_salesperson gs left join t_salesperson s on gs.salesperosn_id = s.id" +
                " left join t_goods g on gs.goods_id = g.id" +
                ";";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Map<String,Object> returnMap = new HashMap<>() ;
                returnMap.put("saleTime",rs.getTimestamp(1));
                returnMap.put("id",rs.getInt(2));
                returnMap.put("goodsName",rs.getString(3));
                returnMap.put("salesName",rs.getString(4));
                returnMap.put("price",rs.getDouble(5));
                returnMap.put("count",rs.getInt(6));
                returnMap.put("total",rs.getDouble(7));
                returnMapList.add(returnMap) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return returnMapList;
    }
    public boolean shoppingSettlement(GoodsSalesperson goodsSalesperson) {
        boolean bool = false;
        conn = DBUtils.getConnetction();
        String sql = "INSERT INTO t_r_goods_salesperson(id,salesperosn_id,goods_id,NUMBER,sales_time) VALUES(?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, goodsSalesperson.getId());
            pstmt.setInt(2, goodsSalesperson.getSalespersonId());
            pstmt.setInt(3, goodsSalesperson.getGoodsId());
            pstmt.setInt(4, goodsSalesperson.getNumber());
            pstmt.setTimestamp(5, DateUtils.getCurrentTimestamp());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(pstmt, conn);
        }
        return bool;
    }
}
