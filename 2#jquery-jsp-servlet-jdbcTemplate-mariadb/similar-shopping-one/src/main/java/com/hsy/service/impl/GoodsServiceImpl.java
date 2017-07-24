package com.hsy.service.impl;
import com.hsy.dao.IGoodsDao;
import com.hsy.entity.Goods;
import com.hsy.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/21 17:49
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService{
    @Autowired
    IGoodsDao goodsDao ;
    @Override
    public List<Goods> selectGoodsListOfPage(Integer currentPage,Integer pageSize) {
        return goodsDao.selectList(currentPage,pageSize);
    }
}
