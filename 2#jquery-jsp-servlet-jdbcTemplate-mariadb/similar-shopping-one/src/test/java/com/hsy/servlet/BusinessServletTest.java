package com.hsy.servlet;

import com.hsy.utils.HttpClientUtils;
import org.junit.Test;
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
        httpUrl += "?businessType=goodsList&currentPage=1&pageSize=2" ;
        System.out.println(HttpClientUtils.sendHttpGet(httpUrl)) ;
    }
}
