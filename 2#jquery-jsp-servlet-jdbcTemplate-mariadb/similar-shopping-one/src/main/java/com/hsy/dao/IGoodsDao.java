package com.hsy.dao;

import com.hsy.entity.Goods;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/21 14:37
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public interface IGoodsDao {
    /**
     * 
     * @description <p>获取商品列表</p>
     * @returnType List<Goods>
     * 方法名:
     * 类名:IGoodsDao
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/21 14:53
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    List<Goods> selectList() ;
    /**
     * 
     * @description <p>通过id获取对象</p>
     * @returnType Goods
     * 方法名:getById
     * 类名:IGoodsDao
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/21 15:48
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    Goods getById(Integer id) ;
}
