package com.hsy.dao;

import com.hsy.entity.Goods;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao
 * @date 2017/7/15 下午5:58
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IGoodsDao {

    boolean addGoods(Goods goods) ;
    boolean updateGoods(int key,Goods goods);
    boolean deleteGoods(int gid);
    List<Goods> queryGoods(int key);
    List<Goods> displayGoods();
    int query(String oper);
    int querySettlement() ;
    List<Goods> queryGoodsKey(int gId,String gName) ;
}
