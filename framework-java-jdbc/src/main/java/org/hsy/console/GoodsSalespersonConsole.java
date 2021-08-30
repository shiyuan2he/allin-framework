package org.hsy.console;

import org.hsy.dao.IGoodsSalespersonDao;
import org.hsy.dao.impl.GoodsSalespersonDaoImpl;
import org.hsy.util.ScannerChoice;

import java.util.List;
import java.util.Map;

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
    /**
     * 
     * @description <p>已售出商品统计</p>
     * 方法名:dailySaleGoodsPage
     * 类名:GoodsSalespersonConsole
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/20 11:16
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public void dailySaleGoodsPage() {
        MainConsole mainConsole = new MainConsole() ;
        IGoodsSalespersonDao goodsSalespersonDao = new GoodsSalespersonDaoImpl() ;
        System.out.println("\t正在执行列出当日售出商品列表操作\n");
        List<Map<String,Object>> gSalesList = goodsSalespersonDao.dailyGsales();//当日售出商品数组集

        if (gSalesList.size() <= 0) {
            System.err.println("\t！！今日无商品售出！！");
            mainConsole.commodityManagementConsole();
        } else {
            System.out.println("\t\t\t\t今日售出商品列表");
            System.out.println("\t售出时间\t\t\t\t\t商品编号\t\t\t商品名称\t\t销售员\t\t\t商品价格\t\t商品数量\t\t销售额");

            for (int i = 0, length = gSalesList.size(); i < length; i++) {
                Map<String,Object> gSalesMap = gSalesList.get(i);
                System.out.println("\t" + gSalesMap.get("saleTime") + "\t\t" + gSalesMap.get("id") + "\t\t\t\t"
                        + gSalesMap.get("goodsName") + "\t\t\t" + gSalesMap.get("salesName") + "\t\t\t$"
                        + gSalesMap.get("price") + "\t\t\t" + gSalesMap.get("count")+ "\t\t\t\t$" + gSalesMap.get("total"));
            }
            do {
                System.out.println("\n\n输入 0 返回上一级菜单");
                String choice = ScannerChoice.scannerInfoString();
                if ("0".equals(choice)) {
                    mainConsole.salespersonManagementConsole();
                }
                mainConsole.commodityManagementConsole();
            } while (true);
        }
    }
}
