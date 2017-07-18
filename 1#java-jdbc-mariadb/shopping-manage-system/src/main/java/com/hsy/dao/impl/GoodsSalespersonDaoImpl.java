package com.hsy.dao.impl;

import com.hsy.dao.IGoodsSalespersonDao;
import com.hsy.entity.GoodsSalesperson;
import com.hsy.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * 1.当天卖出的商品
     *
     * @return ArrayList<Gsales> 商品信息,包括 allSum (单种商品的销售总和)
     */
    public List<GoodsSalesperson> dailyGsales() {
        List<GoodsSalesperson> GsalesList = new ArrayList<GoodsSalesperson>();
        conn = DBUtils.getConnetction();

        //售卖时间=当前时间 trunc(sdate) =trunc(sysdate) 单位：天
        //sql语句解释见files/sql/java_sql.sql
        String sql = "select gname,gprice,gnum, allSum from goods, (select gid as salesid,sum(snum) as allSum from gsales where trunc(sdate) =trunc(sysdate) group by gid) where gid = salesid";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String gName = rs.getString(1);
                double gPrice = rs.getDouble(2);
                Long gNum = rs.getLong(3);
                Long allSnum = rs.getLong("allSum");

               /* GoodsSalesperson Gsales = new GoodsSalesperson(0l, 0l, gNum, allSnum);
                GsalesList.add(Gsales);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return GsalesList;
    }

    /**
     * 2.购物结算-向sales表中插入商品数据！
     * @return boolean
     */
    public boolean shoppingSettlement(GoodsSalesperson goodsSalesperson) {
        boolean bool = false;
        conn = DBUtils.getConnetction();
        String sql = "INSERT INTO GSALES(GID,SID,SNUM) VALUES(?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, goodsSalesperson.getId());
            pstmt.setLong(2, goodsSalesperson.getSalespersonId());
            pstmt.setLong(3, goodsSalesperson.getGoodsId());

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
