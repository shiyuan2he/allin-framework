package com.hsy.dao;

import com.hsy.dao.impl.BaseDaoImpl;
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
public class BaseDaoImplTest {

    @Autowired
    BaseDaoImpl baseDao ;
    @Test
    public void testGetById(){
        System.out.println(baseDao.getByIdOfSuper("select id,name,price,number from t_goods where id = ?",46550930).toString()) ;
    }
}
