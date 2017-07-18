package com.hsy.console;

import com.hsy.dao.IGoodsSalespersonDao;
import com.hsy.dao.impl.GoodsSalespersonDaoImpl;
import com.hsy.entity.GoodsSalesperson;
import com.hsy.util.ScannerChoice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.console
 * @date 18/07/2017 11:33 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class GoodsSalespersonConsole {
    public void dailySaleGoodsPage() {
        IGoodsSalespersonDao goodsSalespersonDao = new GoodsSalespersonDaoImpl() ;
        System.out.println("\t正在执行列出当日售出商品列表操作\n");
        List<GoodsSalesperson> GsalesList = goodsSalespersonDao.dailyGsales();//当日售出商品数组集

        if (GsalesList.size() <= 0) {
            System.err.println("\t！！今日无商品售出！！");
            MainConsole.commodityManagementConsole();
        } else {
            System.out.println("\t\t\t\t今日售出商品列表\n");
            System.out.println("\t商品名称\t\t商品价格\t\t商品数量\t\t销量\t\t备注\n");

            for (int i = 0, length = GsalesList.size(); i < length; i++) {
                //获取售出商品：gname,gprice,gnum, allSum (单种商品的销售总和)
                GoodsSalesperson gSales = GsalesList.get(i);
                //System.out.print("\t" + gSales.getGName() + "\t\t" + gSales.getGPrice() + " $\t\t" + gSales.getGNum() + "\t\t" + gSales.getAllSnum());
                int gNUm = gSales.getNumber();
                if (gNUm == 0) {
                    System.out.println("\t\t该商品已售空");
                } else if (gNUm < 10) {
                    System.out.println("\t\t该商品已不足10件");
                } else {
                    System.out.println("\t\t-");
                }
                System.out.println("\t");
            }
            do {
                System.out.println("\n\n输入 0 返回上一级菜单");
                String choice = ScannerChoice.ScannerInfoString();
                if ("0".equals(choice)) {
                    MainConsole.salespersonManagementConsole();
                }
                MainConsole.commodityManagementConsole();
            } while (true);
        }
    }
}