package com.hsy.servlet;

import com.alibaba.fastjson.JSON;
import com.hsy.utils.HttpClientUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p>Servlet接口层测试类</p>
 * @date 2017/7/22 14:28
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class BusinessServletTest {
    private String httpUrl = "http://localhost:8080/businessType.do" ;
    @Test
    public void testGoodsList(){
        Map<String,Object> paramMap = new HashMap<>() ;
        paramMap.put("businessType","goodsList") ;
        paramMap.put("currentPage",1) ;
        paramMap.put("pageSize",2) ;
        String jsonParam = JSON.toJSONString(paramMap) ;
        System.out.println("请求参数："+jsonParam) ;
        System.out.println(HttpClientUtils.sendHttpPostJson(httpUrl,jsonParam)) ;
    }
}
