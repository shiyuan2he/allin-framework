package org.hsy.console;

import org.hsy.dao.ISalespersonDao;
import org.hsy.dao.impl.SalespersonDaoImpl;
import org.hsy.entity.Salesperson;
import org.hsy.util.MathUtils;
import org.hsy.util.ScannerChoice;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.console
 * @date 2017/7/16 下午11:17
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SalespersonConsole {
    /**
     * @description <p>添加售货员界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:13
     */
    public static void  addSalespersonConsole(){
        ISalespersonDao salespersonDao = new SalespersonDaoImpl() ;
        System.out.println("\t正在执行添加售货员操作\n");
        System.out.println("\n添加售货员-姓名");
        String sName = ScannerChoice.scannerInfoString();
        System.out.println("\n添加售货员-密码");
        String sPssswd = ScannerChoice.scannerInfoString();
        Salesperson salesperson = new Salesperson(MathUtils.generateRandomByLength(8),sName,sPssswd);
        int count = salespersonDao.addSalesperson(salesperson) ;
        if (count>0){
            System.out.println("\n\t!您已成功添加"+count+"名售货员"+sName+"到数据库!");
        }else {
            System.out.println("添加售货员"+sName+"失败");
        }
        ScannerChoice.choiceSalesManNext("addSalesMan");
    }
    /**
     * @description <p>更改售货员界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:13
     */
    public static void updateSalespersonConsole() {
        ISalespersonDao salespersonDao = new SalespersonDaoImpl();
        MainConsole mainConsole = new MainConsole();
        System.out.println("\t正在执行更改售货员操作\n");
        System.out.println("请输入想要更改的售货员名字");
        String sName = ScannerChoice.scannerInfoString();
        //调用精确查找售货员函数
        List<Salesperson> salespersonList = salespersonDao.querySalespersonList(sName);
        if (salespersonList.size() <= 0) {
            System.err.println("\t！！查无此人！！");
            ScannerChoice.choiceSalesManNext("updateSalesMan");
        }else {
            //显示将要更改的售货员信息
            System.out.println("\t\t\t售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");

            Salesperson salesperson = salespersonList.get(0); //上面的精确查找中，只能返回一组数值。无需遍历！
            System.out.println("\t"+salesperson.getId()+"\t\t\t"+salesperson.getName()+"\t\t\t"+salesperson.getPassword());
            System.out.println();

            //选择更改售货员内容
            System.out.println("\n--------请选择您要更改的内容\n");
            System.out.println("\t1.更改售货员-姓名");
            System.out.println("\t2.更改售货员-密码");
            do{
                String choice = ScannerChoice.scannerInfoString();
                String regex  = "[0-2]";
                if (choice.matches(regex)) {
                    int info = Integer.parseInt(choice);
                    switch (info) {
                        case 0:
                            mainConsole.salespersonManagementConsole();
                            break;
                        case 1:
                            System.out.println("更改售货员-新姓名");
                            String sNewName = ScannerChoice.scannerInfoString();
                            Salesperson salesManName = new Salesperson(salesperson.getId(),sNewName,null);
                            int count = salespersonDao.updateSalesperson(1, salesManName);
                            if (count > 0) {
                                System.out.println("\n\t！！成功更新售货员名字至数据库！！\n");
                            }else {
                                System.err.println("\n\t！！更新售货员名字失敗！！");
                            }
                            ScannerChoice.choiceSalesManNext("updateSalesMan");
                            break;
                        case 2:
                            System.out.println("更改售货员-新密码");
                            String sNewPasswd = ScannerChoice.scannerInfoString();
                            Salesperson salesManPasswd = new Salesperson(salesperson.getId(),null,sNewPasswd);
                            int countSussess = salespersonDao.updateSalesperson(2, salesManPasswd);
                            if (countSussess>0) {
                                System.out.println("\n\t！！成功更新售货员密码至数据库！！\n");
                            }else {
                                System.err.println("\n\t！！更新售货员密码失敗！！");
                            }
                            ScannerChoice.choiceSalesManNext("updateSalesMan");
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("\t!输入有误!");
                System.out.println("\n请选择选项.或者按 0 返回上一级菜单.");
            } while (true);
        }
    }
    /**
     * @description <p>删除售货员界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:13
     */
    public static void deleteSalespersonConsole(){
        ISalespersonDao salespersonDao = new SalespersonDaoImpl() ;
        MainConsole mainConsole = new MainConsole() ;
        System.out.println("\t正在执行 删除售货员 操作\n");
        System.out.println("请输入想要删除的售货员名字");
        String sName = ScannerChoice.scannerInfoString();
        //调用精确查找售货员函数
        List<Salesperson> salespersonList = salespersonDao.querySalespersonList(sName);
        if (salespersonList.size() <= 0) {
            System.err.println("\t！！查无此人！！");
            ScannerChoice.choiceSalesManNext("deleteSalesMan");
        }else {
            //显示将要删除的售货员信息
            System.out.println("\t\t\t删除售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");

            for (int i = 0,length = salespersonList.size(); i < length; i++){
                Salesperson salesperson = salespersonList.get(i);
                System.out.println("\t"+salesperson.getId()+"\t\t\t"+salesperson.getName()+"\t\t\t"+salesperson.getPassword());
                System.out.println();
            }
            //确认是否真的删除！
            do {
                System.out.println("\n确认删除该售货员：Y/N");
                String choice = ScannerChoice.scannerInfoString();
                if ("y".equals(choice) || "Y".equals(choice)){
                    //进行刪除-数据库操作
                    int count = salespersonDao.deleteSalesperson(sName);//調用刪除功能
                    if (count > 0){
                        System.err.println("\t！！已成功刪除该售货员！！\n");
                    }else{
                        System.err.println("\t！！刪除该售货员失败！！");
                    }
                    ScannerChoice.choiceSalesManNext("deleteGoods");
                }else if ("N".equals(choice) || "n".equals(choice)) {
                    mainConsole.salespersonManagementConsole();
                }
                System.err.println("\t!!输入有误,请重新输入!!");
            } while (true);
        }
    }
    /**
     * @description <p>查询售货员界面 已实现！</p>
     * @author heshiyuan
     * @date 2017/7/20 11:12
     */
    public static void querySalespersonConsole() {
        ISalespersonDao salespersonDao = new SalespersonDaoImpl() ;
        System.out.println("\t\t  正在执行查询售货员操作\n");
        System.out.println("要查询的售货员关键字");
        String sName = ScannerChoice.scannerInfoString();
        List<Salesperson> salespersonList = salespersonDao.querySalespersonList(sName);
        if (salespersonList.size() <=0) {
            System.err.println("\t！没有人员符合查询条件！");
        }else {
            System.out.println("\t\t\t\t\t所有售货员列表");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
            for (int i = 0,length = salespersonList.size(); i < length; i++) {
                Salesperson salesperson = salespersonList.get(i);
                System.out.println("\t"+salesperson.getId()+"\t\t\t"+salesperson.getName()+"\t\t\t"+salesperson.getPassword());
            }
        }
        ScannerChoice.choiceSalesManNext("querySalesMan"); //param：调用者
    }
    /**
     * @description <p>显示所有售货员界面</p>
     * @author heshiyuan
     * @date 2017/7/20 11:12
     */
    public static void displaySalespersonConsole() {
        ISalespersonDao salespersonDao = new SalespersonDaoImpl() ;
        List<Salesperson> salesManList = salespersonDao.queryAllSalespersonList();
        if (salesManList.size() <= 0) {
            System.err.println("\t！！售货员列表为空！！");
            //MainPage.salesManManagementPage();
        }else{
            System.out.println("\t\t\t所有售货员列表");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
            for (int i = 0,length = salesManList.size(); i < length; i++) {
                Salesperson salesperson = salesManList.get(i);
                System.out.println("\t"+salesperson.getId()+"\t\t\t"+salesperson.getName()+"\t\t\t"+salesperson.getPassword());
            }
            do {
                System.out.println("\n\n输入 0 返回上一级菜单");
                String choice = ScannerChoice.scannerInfoString();
                if ("0".equals(choice)) {
                    MainConsole.salespersonManagementConsole();
                }
                System.err.print("\t输入有误！");
            } while (true);
        }
    }
}
