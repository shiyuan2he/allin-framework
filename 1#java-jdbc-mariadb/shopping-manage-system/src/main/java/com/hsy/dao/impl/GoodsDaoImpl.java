package com.hsy.dao.impl;

import com.hsy.console.GoodsConsole;
import com.hsy.dao.IGoodsDao;
import com.hsy.entity.Goods;
import com.hsy.util.DBUtils;
import com.hsy.util.ScannerChoice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao.impl
 * @date 2017/7/15 下午5:58
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class GoodsDaoImpl extends BaseDaoImpl implements IGoodsDao {
    ScannerChoice scannerChoice = new ScannerChoice();

    /**
     * 1.添加商品到数据库goods表
     *
     * @param goods 商品对象
     * @return boolean
     */
    public boolean addGoods(Goods goods) {
        boolean bool = false;
        conn = DBUtils.getConnetction();
        String sql = "INSERT INTO t_GOODS(id,NAME,PRICE,number) VALUES(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, goods.getId());
            pstmt.setString(2, goods.getName());
            pstmt.setDouble(3, goods.getPrice());
            pstmt.setInt(4, goods.getNumber());
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

    /**
     * 2.更改商品信息到数据库goods表
     *
     * @param key   选择要更改商品信息
     * @param goods 商品对象
     * @return boolean
     */
    public boolean updateGoods(int key, Goods goods) {
        boolean bool = false;
        conn = DBUtils.getConnetction();
        switch (key) {
            case 1:        //	key=1,更改商品名称
                String sqlName = "UPDATE t_goods SET NAME=? WHERE ID=?";
                try {
                    pstmt = conn.prepareStatement(sqlName);
                    pstmt.setString(1, goods.getName());
                    pstmt.setLong(2, goods.getId());
                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        bool = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBUtils.closeResource(pstmt, conn);
                }
                break;
            case 2:        //	key=2,更改商品价格
                String sqlPrice = "UPDATE t_goods SET PRICE=? WHERE ID=?";
                try {
                    conn = DBUtils.getConnetction();
                    pstmt = conn.prepareStatement(sqlPrice);
                    pstmt.setDouble(1, goods.getPrice());
                    pstmt.setLong(2, goods.getId());
                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        bool = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBUtils.closeResource(pstmt, conn);
                }
                break;
            case 3:        //	key=3,更改商品数量
                String sqlNum = "UPDATE t_goods SET number=? WHERE ID=?";
                try {
                    conn = DBUtils.getConnetction();
                    pstmt = conn.prepareStatement(sqlNum);
                    pstmt.setInt(1, goods.getNumber());
                    pstmt.setLong(2, goods.getId());
                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        bool = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBUtils.closeResource(pstmt, conn);
                }
                break;
            default:
                break;
        }
        return bool;
    }

    /**
     * 3.从数据库goods表中-刪除商品
     *
     * @param id 商品编号
     * @return boolean
     */
    public boolean deleteGoods(int id) {
        boolean bool = false;
        String sql = "DELETE FROM t_GOODS WHERE ID=?";
        try {
            conn = DBUtils.getConnetction();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1,id);
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

    /**
     * 4.查询商品信息
     *
     * @param key 查询方式
     * @return ArrayList<Goods>
     */
    public List<Goods> queryGoods(int key) {
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        conn = DBUtils.getConnetction();
        switch (key) {
            case 1:
                //	key=1商品 数量 升序查询
                String sqlGnum = "SELECT * FROM t_goods ORDER BY NUMBER ASC";
                try {
                    pstmt = conn.prepareStatement(sqlGnum);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString(2);
                        Double price = rs.getDouble(3);
                        int num = rs.getInt(4);
                        Goods goods = new Goods(id, name, price, num);
                        goodsList.add(goods);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBUtils.closeResource(pstmt, rs, conn);
                }
                break;
            case 2:
                //	key=2商品 价格 升序查询
                String sqlGprice = "SELECT * FROM t_goods ORDER BY PRICE ASC";
                try {
                    pstmt = conn.prepareStatement(sqlGprice);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString(2);
                        Double price = rs.getDouble(3);
                        int num = rs.getInt(4);
                        Goods goods = new Goods(id, name, price, num);
                        goodsList.add(goods);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBUtils.closeResource(pstmt, rs, conn);
                }
                break;
            case 3:
                //	key=3商品 关键字 查询
                String nameGet = ScannerChoice.scannerInfoString();
                String sqlGname = "SELECT * FROM t_goods WHERE NAME LIKE '%'||?||'%'";
                try {
                    pstmt = conn.prepareStatement(sqlGname);
                    pstmt.setString(1, nameGet);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString(2);
                        Double price = rs.getDouble(3);
                        int num = rs.getInt(4);
                        Goods goods = new Goods(id, name, price, num);
                        goodsList.add(goods);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBUtils.closeResource(pstmt, rs, conn);
                }
                break;
            default:
                break;
        }
        return goodsList;
    }

    /**
     * @description <p>显示所有商品信息</p>
     * @returnType Map<String,String>
     * 方法名:
     * 类名:GoodsDaoImpl
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/18 11:53
     * @price ￥:5毛
     * @copyright 此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public List<Goods> displayGoods() {
        List<Goods> goodsList = new ArrayList<Goods>();
        conn = DBUtils.getConnetction();
        String sql = "SELECT * FROM t_goods";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Double price = rs.getDouble("price");        //双引号+主键名,也可用数字表示.
                int gnum = rs.getInt(4);
                Goods goods = new Goods(id, name, price, gnum);    //创建Goods对象，并赋值.
                goodsList.add(goods);                            //添加信息到动态数组中.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return goodsList;
    }

    public int query(String oper) {
        int id = -1;
        //键盘获取商品名字
        String shopping = ScannerChoice.scannerInfoString();
        //根据键盘获取的商品名字调用精确查询函数，确定用戶所要操作的数据
        List<Goods> goodsList = queryGoodsKey(-1, shopping);
        if (goodsList == null || goodsList.size() <= 0) {
            System.err.println("\t！！查无此商品 ！！");
            //调用选择下一步函数
            scannerChoice.changedInfoNext(oper);
        } else {
            //查到有此商品，实现进行 更改商品 信息操作！
            Goods goods = goodsList.get(0);
            System.out.println("\t\t\t\t\t\t\t商品列表");
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注");
            System.out.println("\t" + goods.getId() + "\t\t" + goods.getName() + "\t\t\t" + goods.getPrice() + "\t\t\t" + goods.getNumber());
            GoodsConsole.consoleRemark(goods.getNumber());
            id = goods.getId(); //将商品编号返回给调用者
        }
        return id;
    }

    /**
     * 模糊查询函数小工具
     *
     * @return int 当商品件数有且只有一件时返回商品gid号，商品已售空时返回 -1. >1件时返回-2 . 查无此商品时返回-3
     */
    public int querySettlement() {
        int gid = -1;
        List<Goods> goodsSettlement = queryGoods(3);//調用 关键字查询函数
        if (goodsSettlement == null || goodsSettlement.size() <= 0) {
            System.err.println("\t！！查无此商品 ！！\n");
            gid = -3;
        } else {
            //查到有此商品，实现进行 更改商品 信息操作！
            System.out.println("\t\t\t\t\t\t\t商品列表");
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注");
            for (int i = 0; i < goodsSettlement.size(); i++) {
                Goods goods = goodsSettlement.get(i);
                if (goods.getNumber() > 0) {
                    System.out.print("\t" + goods.getId() + "\t\t" + goods.getName() + "\t\t\t" + goods.getPrice() + "\t\t\t" + goods.getNumber());
                    GoodsConsole.consoleRemark(goods.getNumber());
                    if (goodsSettlement.size() == 1) {
                        gid = Integer.parseInt(goods.getId().toString()); //将商品编号返回给调用者
                    } else {
                        gid = -2;
                    }
                }
            }
        }
        return gid;
    }

    /**
     * 根据商品 gid or gName查询商品
     *
     * @return 商品信息
     */
    public List<Goods> queryGoodsKey(int id, String name) {
        List<Goods> goodsList = new ArrayList<Goods>();
        String sql = "SELECT * FROM t_GOODS WHERE ID=? OR NAME=?";
        try {
            conn = DBUtils.getConnetction();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                goodsList.add(convertBean(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(pstmt, rs, conn);
        }
        return goodsList;
    }
    /**
     * 
     * @description <p>封装转化结果集为bean</p>
     * @returnType Map<String,String>
     * 方法名:
     * 类名:GoodsDaoImpl
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/19 11:46
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    private Goods convertBean(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        Double price = rs.getDouble(3);
        int num = rs.getInt(4);
        return new Goods(id, name, price, num);
    }
}
