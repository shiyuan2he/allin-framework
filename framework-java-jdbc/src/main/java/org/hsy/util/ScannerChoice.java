package org.hsy.util;

import org.hsy.console.GoodsConsole;
import org.hsy.console.MainConsole;
import org.hsy.console.SalespersonConsole;

import java.util.Scanner;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.util
 * @date 2017/7/16 上午9:55
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ScannerChoice {
    /**
     * @return double 键盘获取商品价格,小数点后两位
     */
    public static double scannerInfo() {
        double num = 0.00;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("保留小数点后两位,请输入：");
            String info = sc.next();
            String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
            if (info.matches(regex)) {
                num = Double.parseDouble(info);
            }else {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);
        return num;
    }
    /**
     * @return int 键盘获取商品数量
     */
    public static int ScannerNum() {
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";//商品数量
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入：");
            String nums = sc.next();

            if (nums.matches(regex)) {
                num = Integer.parseInt(nums);
            }else {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);
        return num;
    }

    /**
     * @return String 获取的键盘输入
     */
    public static String scannerInfoString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入：");
        return scanner.next();
    }

    /**
     * 获取用户-更改完商品-下一步
     * 获取用户-删除完商品-下一步
     * 获取用户-添加完商品-下一步
     */
    public static void changedInfoNext(String oper) {
        do{
            System.out.println("是否继续进行-当前操作:(Y/N)");
            String choice = ScannerChoice.scannerInfoString();
            //在JAVA中: Equals比较的是值,==比较的是地址
            if ("y".equals(choice) || "Y".equals(choice)) {
                //下面的嵌套if-else 是让用户选择继续操作当前步骤所跳转到指定页面。（因为不同函数调用，跳转的指定函数不同）
                if ("upateGoodsPage".equals(oper)) {
                    GoodsConsole.upateGoodsConsole();
                }else if ("deleteGoodsPage".equals(oper)) {
                    GoodsConsole.deleteGoodsConsole();
                }else if ("addGoodsPage".equals(oper)) {
                    GoodsConsole.addGoodsConsole();
                }
                //上面的嵌套结束
            }else if ("N".equals(choice) || "n".equals(choice)) {
                MainConsole.CommodityMaintenanceConsole();
            }
            System.out.println("\n输入有误！请重新输入.");
        } while (true);
    }

    /**
     * 获取用户-更改-完售货员-下一步
     * 获取用户-添加-完售货员-下一步
     * 获取用户-查询-完售货员-下一步
     * 获取用户-删除-完售货员-下一步
     */
    public static void choiceSalesManNext(String oper) {
        do{
            System.out.println("是否继续进行-当前操作:(Y/N)");
            String choice = ScannerChoice.scannerInfoString();
            if ( "y".equals(choice) || "Y".equals(choice) ){
                //下面的嵌套if-else 是让用户选择继续操作当前步骤所跳转到指定页面。（因为不同函数调用，跳转的指定函数不同）
                if ("updateSalesMan".equals(oper)) {
                    SalespersonConsole.updateSalespersonConsole();
                }else if ("deleteSalesMan".equals(oper)) {
                    SalespersonConsole.deleteSalespersonConsole();
                }else if ("addSalesMan".equals(oper)) {
                    SalespersonConsole.addSalespersonConsole();
                }else if ("querySalesMan".equals(oper)) {
                    SalespersonConsole.querySalespersonConsole();
                }
                //上面的嵌套结束
            }else if ("N".equals(choice) || "n".equals(choice)) {
                MainConsole.salespersonManagementConsole();
            }
            System.err.println("\t输入有误！");
        } while (true);
    }
}
