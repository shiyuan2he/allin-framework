package com.hsy.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/21 13:51
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-all.xml")
public class GoodsDaoImplTest {
    @Autowired
    IGoodsDao goodsDao ;
    @Test
    public void testSelectGoodsList(){
        System.out.println(goodsDao.selectList(1,4).toString()) ;
    }
    @Test
    public void testGetById(){
        System.out.println(goodsDao.getById(46550930).toString()) ;
    }
}
