package com.hsy.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hsy.bean.ResponseBean;
import com.hsy.entity.Goods;
import com.hsy.service.IGoodsService;
import com.hsy.util.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Constant.requestThreadLocal = new ThreadLocal<HttpServletRequest>(){
            @Override
            protected HttpServletRequest initialValue() {
                return request ;
            }
        };
        Constant.responseThreadLocal =  new ThreadLocal<HttpServletResponse>(){
            @Override
            protected HttpServletResponse initialValue() {
                return response ;
            }
        };
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        goodsService = (IGoodsService) wac.getBean("goodsService");
        Enumeration<String> parameterNames = request.getParameterNames();
        String businessType = request.getParameter("businessType") ;
        if(StringUtils.equalsIgnoreCase(businessType,"goodsList")){
            String currentPage = request.getParameter("currentPage") ;
            String pageSize = request.getParameter("pageSize") ;
            List<Goods> goodsList = goodsService.selectGoodsListOfPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize)) ;
            for(Goods goods : goodsList){
                System.out.println("id:{"+goods.getId()+"} name:{"+goods.getName()+"} price:{"+goods.getPrice()+"} number:{"+goods.getNumber()+"}") ;
                _logger.info("id:{"+goods.getId()+"} name:{"+goods.getName()+"} price:{"+goods.getPrice()+"} number:{"+goods.getNumber()+"}") ;
            }
            //request.setAttribute("goodsList",goodsService.selectGoodsListOfPage());
            //request.getRequestDispatcher("/website/goods/goods-list.jsp").forward(request,response);
            long countAll = 0l;
            try{
                countAll = (long)Constant.requestThreadLocal.get().getAttribute("totalCount") ;
            }catch(Exception e){
                e.printStackTrace();
            }
            writeJson(request,response,new ResponseBean("0000","success",
                    goodsList,Integer.parseInt(currentPage),Integer.parseInt(pageSize),
                    countAll));
        }else if("add".equals(businessType)){
            String currentPage = request.getParameter("name") ;
            //doAddGoods() ;
        }
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

    public static String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }
}
