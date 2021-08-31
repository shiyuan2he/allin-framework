package com.hsy;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/PACKAGE_NAME
 * @date 20/08/2017 5:00 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/webapp")
@ContextConfiguration({"classpath*:/spring/spring-context.xml","classpath*:/spring/spring-webmvc.xml"})
public abstract class JUnit4ControllerBase {
    @Autowired
    WebApplicationContext wac  ;
    MockMvc moc ;
    @Before
    public void before(){
        this.moc = webAppContextSetup(this.wac).build() ;
    }

    public void postJsonRequest(String url,String json){
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = post(url)
                .contentType("application/json;charset=UTF-8").content(json);
        try {
            moc.perform(mockHttpServletRequestBuilder)
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
