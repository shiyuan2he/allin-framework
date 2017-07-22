package com.hsy.servlet;

import com.hsy.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/22 14:28
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-all.xml")
public class BusinessServletTest {
    private String httpUrl = "http://localhost:8080/businessType.do" ;
    @Test
    public void testGoodsList(){
        httpUrl += "?businessType=goodsList" ;
        System.out.println(HttpClientUtils.sendHttpGet(httpUrl)) ;
    }
}
