package org.hsy.console;
import org.hsy.dao.IGoodsDao;
import org.hsy.dao.IGoodsSalespersonDao;
import org.hsy.dao.ISalespersonDao;
import org.hsy.dao.impl.GoodsDaoImpl;
import org.hsy.dao.impl.GoodsSalespersonDaoImpl;
import org.hsy.dao.impl.SalespersonDaoImpl;
import org.hsy.entity.Goods;
import org.hsy.entity.GoodsSalesperson;
import org.hsy.entity.Salesperson;
import org.hsy.util.Algorithm;
import org.hsy.util.MathUtils;
import org.hsy.util.ScannerChoice;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p>管理系统主页面</p>
 * @path framework/com.hsy.console
 * @date 2017/7/15 下午6:12
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class MainConsole {
    /**
     * 入口
     * @description <p>入口</p>
     * @author heshiyuan
     * @date 2017/7/20 11:13
     */
    public static void main(String[] args) {
        MainConsole.mainConsole();
    }
    /**
     * @description <p>主界面 已实现！已校验！</p>
     * @author heshiyuan
     * @date 2017/7/20 11:11
     */
    public static void mainConsole() {
        System.out.println("***************************\n");
        System.out.println("\t 1.商品维护\n");
        System.out.println("\t 2.前台收银\n");
        System.out.println("\t 3.商品管理\n");
        System.out.println("***************************");
        MainConsole mainConsole = new MainConsole();
        System.out.println("\n请输入选项,或者按0退出.");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-3]";
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(1);//退出程序，返回值随便设置
                        break;
                    case 1:
                        mainConsole.CommodityMaintenanceConsole();
                        break;
                    case 2:
                        mainConsole.checkstandLogConsole();
                        break;
                    case 3:
                        mainConsole.commodityManagementConsole();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按0退出.");
        } while (true);
    }
    /**
     * @description <p>商品维护界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:11
     */
    public static void CommodityMaintenanceConsole() {
        GoodsConsole goodsConsole = new GoodsConsole();
        System.out.println("***************************\n");
        System.out.println("\t 1.添加商品\n");
        System.out.println("\t 2.更改商品\n");
        System.out.println("\t 3.删除商品\n");
        System.out.println("\t 4.查询商品\n");
        System.out.println("\t 5.显示所有商品\n");
        System.out.println("***************************");
        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainConsole();
                        break;
                    case 1:
                        goodsConsole.addGoodsConsole();
                        break;
                    case 2:
                        goodsConsole.upateGoodsConsole();
                        break;
                    case 3:
                        goodsConsole.deleteGoodsConsole();
                        break;
                    case 4:
                        goodsConsole.queryGoodsConsole();
                        break;
                    case 5:
                        goodsConsole.displayGoodsConsole();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新输入或按 0 返回上一级菜单.");
        } while (true);
    }
    /**
     * @description <p>前台收银登陆界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:11
     */
    public static void checkstandLogConsole() {
        System.out.println("\n*******欢迎使用商超购物管理系统*******\n");
        System.out.println("\t 1.登录系统\n");
        System.out.println("\t 2.退出\n");
        System.out.println("-----------------------------");
        System.out.println("请输入选项,或者按 0 返回上一级菜单.");
        ISalespersonDao salespersonDao = new SalespersonDaoImpl();

        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainConsole();
                        break;
                    case 1:
                        int loginTimes = 3;//3次登陆机会
                        while (loginTimes != 0) {
                            loginTimes--;
                            System.out.println("---用户名---");
                            String sName = ScannerChoice.scannerInfoString();
                            System.out.println("---密码---");
                            String sPssWord = ScannerChoice.scannerInfoString();

                            List<Salesperson> salesManInfo = salespersonDao.checkstandLog(sName); //以用户名从数据库中获取用户密码.
                            //没有此用户的情况！
                            if (salesManInfo == null || salesManInfo.size() == 0) {
                                System.err.println("\t!!用户名输入有误!!\n");
                                System.out.println("\n剩余登陆次数：" + loginTimes);
                            } else {
                                Salesperson salesperson = salesManInfo.get(0);//此地，只返回了一组数值，只遍历1次即可
                                //验证密码，登陆成功了！！
                                if (sPssWord.equals(salesperson.getPassword())){
                                    System.out.println("\t  ---账户成功登陆---");
                                    shoppingSettlementConsole(salesperson.getId());//参数为营业员编号sId
                                } else {
                                    System.err.println("\t!!密码错误!!\n");
                                    System.out.println("\n剩余登陆次数：" + loginTimes);
                                }
                            }
                        }
                        //loginTimes = 0
                        System.out.println("------------------");
                        System.err.println("\t！！您已被强制退出系统！！");
                        System.exit(1);
                        break;
                    case 2:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(-1);
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新输入或按 0 返回上一级菜单");
        } while (true);
    }
    /**
     * @description <p>商品管理控制台</p>
     * @author heshiyuan 
     * @date 2017/7/20 11:11
     */
    public static void commodityManagementConsole() {
        System.out.println("***************************\n");
        System.out.println("\t 1.售货员管理\n");
        System.out.println("\t 2.列出当日卖出列表\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
        GoodsSalespersonConsole goodsSalespersonConsole = new GoodsSalespersonConsole() ;
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainConsole();
                        break;
                    case 1:
                        salespersonManagementConsole();
                        break;
                    case 2:
                        goodsSalespersonConsole.dailySaleGoodsPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新输入或按 0 返回上一级菜单.");
        } while (true);
    }
    /**
     *
     * @description <p>购物结算界面</p>
     * 方法名:shoppingSettlementConsole
     * 类名:MainConsole
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/20 11:02
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public static void shoppingSettlementConsole(Integer salesManSid) {
        IGoodsDao goodsDao = new GoodsDaoImpl();
        IGoodsSalespersonDao goodsSalespersonDao = new GoodsSalespersonDaoImpl();
        System.out.println("\n\t*******购物结算*******\n");
        do {
            System.out.println("按 S 开始购物结算.按 0 返回账户登录界面");
            String choNext = ScannerChoice.scannerInfoString();
            if ("0".equals(choNext)) {
                checkstandLogConsole();
            } else if ("s".equals(choNext) || "S".equals(choNext)) {
                System.out.println("\n--请输入商品关键字--");
                int gid = goodsDao.querySettlement();//当商品件数有且只有一件时返回商品gid号，商品已售空时返回 -1. >1件时返回-2 . 查无此商品时返回-3
                switch (gid) {
                    case -3:
                        //无此商品,重新循环
                        break;
                    case -1:
                        System.err.println("\t--抱歉，该商品已售空--");
                        break;
                    default:
                        System.out.println("--按商品编号选择商品--");
                        //传参gid，调用精确查询商品
                        int shoppingGid = ScannerChoice.ScannerNum();
                        List<Goods> goodsList = goodsDao.queryGoodsKey(shoppingGid, null);
                        if (goodsList == null || goodsList.size() == 0) {
                            System.err.println("\t！！查无此商品 ！！\n");
                        } else {
                            Goods goods = goodsList.get(0);
                            int gNum = goods.getNumber();
                            double gPrice = goods.getPrice();
                            System.out.println("--请输入购买数量--");
                            do {
                                int choicegoodsNum = ScannerChoice.ScannerNum();//获取用户要购买的数量
                                if (choicegoodsNum > gNum) {
                                    System.err.println("\t！！仓库储备不足！！");
                                    System.out.println("--请重新输入购买数量--");
                                } else {
                                    double allPrice = Algorithm.mul(choicegoodsNum, gPrice);//利用BigDecimal作乘法运算
                                    System.out.println("\t\t\t\t\t购物车结算");
                                    System.out.println("\t\t商品名称\t商品单价\t购买数量\t总价");
                                    System.out.println("\t\t" + goods.getName() + "\t\t$" + gPrice + " \t" + choicegoodsNum + "\t\t\t$" + allPrice + " \n");

                                    do {
                                        System.out.println("确认购买：Y/N");
                                        String choShopping = ScannerChoice.scannerInfoString();
                                        if ("y".equals(choShopping) || "Y".equals(choShopping)) {
                                            System.out.println("\n总价：" + allPrice + " $");
                                            System.out.println("\n实际缴费金额");
                                            do {
                                                double amount = ScannerChoice.scannerInfo();
                                                double balance = Algorithm.sub(amount, allPrice);  //用户交钱与购买物品总价间的差额
                                                if (balance < 0) {
                                                    System.err.println("\t！！缴纳金额不足！！");
                                                    System.out.println("\n请重新输入缴纳金额($)");
                                                } else {
                                                    /*	这里是购物结算操作数据库！！！！！！----------------------	  1.更改t_goods表数量*/
                                                    //对sales表操作
                                                    GoodsSalesperson gSales = new GoodsSalesperson(MathUtils.generateRandomByLength(8),goods.getId(),
                                                            salesManSid, choicegoodsNum, null);
                                                    boolean insert = goodsSalespersonDao.shoppingSettlement(gSales);
                                                    //对goods表操作
                                                    int goodsNewNum = gNum - choicegoodsNum; //现在goods表中该商品数量
                                                    Goods newGoods = new Goods(goods.getId(), goodsNewNum);
                                                    boolean update = goodsDao.updateGoods(3, newGoods);

                                                    if (update && insert) {
                                                        System.out.println("找零：" + balance);
                                                        System.out.println("\n谢谢光临，欢迎下次惠顾");
                                                    } else {
                                                        System.err.println("！支付失败！"); //出现这个错误一定是数据库操作有问题！
                                                    }
                                                    shoppingSettlementConsole(salesManSid);//最后跳转到到购物结算页面
                                                    //	结束购物结算操作数据库！！！！！！-----------------------------------
                                                }
                                            } while (true);
                                        } else if ("N".equals(choShopping) || "n".equals(choShopping)) {
                                            shoppingSettlementConsole(salesManSid);
                                        }
                                        System.err.println("\t！！请确认购物意向！！");
                                    } while (true);
                                }
                            } while (true);
                        }
                        break;
                }
            } else {
                System.err.println("\t!!请输入合法字符!!\n");
            }
        } while (true);
    }
    /**
     * @description <p>售货员管理界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:07
     */
    public static void salespersonManagementConsole() {
        System.out.println("***************************\n");
        System.out.println("\t 1.添加售货员\n");
        System.out.println("\t 2.更改售货员\n");
        System.out.println("\t 3.删除售货员\n");
        System.out.println("\t 4.查询售货员\n");
        System.out.println("\t 5.显示所有售货员\n");
        System.out.println("***************************");
        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
        SalespersonConsole salespersonConsole = new SalespersonConsole();
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        commodityManagementConsole();
                        break;
                    case 1:
                        salespersonConsole.addSalespersonConsole();
                        break;
                    case 2:
                        salespersonConsole.updateSalespersonConsole();
                        break;
                    case 3:
                        salespersonConsole.deleteSalespersonConsole();
                        break;
                    case 4:
                        salespersonConsole.querySalespersonConsole();
                        break;
                    case 5:
                        salespersonConsole.displaySalespersonConsole();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("\t!输入有误!");
            System.out.println("重新输入或按 0 返回上一级菜单.");
        } while (true);
    }
}
