package org.hsy.dao.impl;

import org.hsy.dao.ISalespersonDao;
import org.hsy.entity.Salesperson;
import org.hsy.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao.impl
 * @date 2017/7/15 下午5:59
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SalespersonDaoImpl extends BaseDaoImpl implements ISalespersonDao {

    public int addSalesperson(Salesperson salesperson){
        boolean bool = false;
        conn = DBUtils.getConnetction() ;
        String sql = "INSERT INTO t_salesperson(ID,NAME,PASSWORD) VALUES(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1,salesperson.getId());
            pstmt.setString(2,salesperson.getName());
            pstmt.setString(3,salesperson.getPassword());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return rs ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(pstmt,conn);
        }
        return 0 ;
    }

    public List<Salesperson> querySalespersonList(String name) {
        List<Salesperson> salespersonList = new ArrayList<Salesperson>();
        conn = DBUtils.getConnetction() ;
        String sql = "SELECT * FROM t_salesperson WHERE NAME=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int ids = rs.getInt("id");
                String returnName = rs.getString(2);
                String passWord = rs.getString(3);
                Salesperson salesMan = new Salesperson(ids,returnName,passWord);
                salespersonList.add(salesMan);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return salespersonList;
    }

    public int updateSalesperson(int key,Salesperson salesperson) {
        conn = DBUtils.getConnetction() ;
        switch (key) {
            case 1:		//	3.1 更改售货员姓名
                String sqlName = "UPDATE t_salesperson SET NAME=? WHERE ID=?";
                try {
                    pstmt = conn.prepareStatement(sqlName);
                    pstmt.setString(1, salesperson.getName());
                    pstmt.setLong(2,salesperson.getId());
                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                       return rs ;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    DBUtils.closeResource(pstmt,conn);
                }
                break;
            case 2:		//	3.2 更改售货员密码
                String sqlPrice = "UPDATE SALESMAN SET SPASSWORD=? WHERE SID=?";
                try {
                    pstmt = conn.prepareStatement(sqlPrice);
                    pstmt.setString(1,salesperson.getPassword());
                    pstmt.setLong(2, salesperson.getId());
                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        return rs ;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    DBUtils.closeResource(pstmt,conn);
                }
                break;
            default:
                break;
        }
        return 0;
    }

    public int deleteSalesperson(String name) {
        boolean bool = false;
        conn = DBUtils.getConnetction();
        String sql = "DELETE FROM t_salesperson WHERE NAME=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return rs ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeResource(pstmt,conn);
        }
        return 0;
    }

    public List<Salesperson> queryAllSalespersonList() {
        ArrayList<Salesperson> salesManList = new ArrayList<Salesperson>();
        conn = DBUtils.getConnetction();
        String sql = "SELECT * FROM t_salesperson";
        try {
            pstmt = conn.prepareStatement(sql);
            rs =  pstmt.executeQuery();
            while (rs.next()) {
                int sId = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                Salesperson salesMan = new Salesperson(sId,name,password);
                salesManList.add(salesMan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return salesManList;
    }
    /**
     * 1.前台收银登陆
     * @param sName 用户名
     * @return List<SalesMan> sPassWord,sId
     */
    public List<Salesperson> checkstandLog(String sName){
        ArrayList<Salesperson> salesManInfo = new ArrayList<Salesperson>();
        conn = DBUtils.getConnetction();
        String sql = "SELECT ID,PASSWORD FROM t_salesperson WHERE NAME=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sName);
            rs 	  = pstmt.executeQuery();
            while (rs.next()){
                String sPassWord = rs.getString("password");
                int sId = rs.getInt("id");
                Salesperson salesMan = new Salesperson(sId,sPassWord);
                salesManInfo.add(salesMan);
            }
        } catch (SQLException e1){
            e1.printStackTrace();
        }finally{
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return salesManInfo;
    }


}
