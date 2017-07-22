package com.hsy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hsy.bean.ResponseBean;
import com.hsy.entity.Goods;
import com.hsy.service.IGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/21 16:44
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@WebServlet("/businessType.do")
public class BusinessServlet extends HttpServlet {
    private static final Logger _logger = Logger.getLogger(BusinessServlet.class) ;
    IGoodsService goodsService ;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        goodsService = (IGoodsService) wac.getBean("goodsService");
        String businessType = request.getParameter("businessType") ;
        if(StringUtils.equalsIgnoreCase(businessType,"goodsList")){
            List<Goods> goodsList = goodsService.selectGoodsListOfPage() ;
            for(Goods goods : goodsList){
                System.out.println("id:{"+goods.getId()+"} name:{"+goods.getName()+"} price:{"+goods.getPrice()+"} number:{"+goods.getNumber()+"}") ;
                _logger.info("id:{"+goods.getId()+"} name:{"+goods.getName()+"} price:{"+goods.getPrice()+"} number:{"+goods.getNumber()+"}") ;
            }
            //request.setAttribute("goodsList",goodsService.selectGoodsListOfPage());
            //request.getRequestDispatcher("/website/goods/goods-list.jsp").forward(request,response);
            writeJson(request,response,new ResponseBean("0000","success",goodsList));
        }
    }

    private void writeHtml(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
    private void writeJson(HttpServletRequest request, HttpServletResponse response,Object obj) {
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(JSONArray.toJSONString(obj)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

}
