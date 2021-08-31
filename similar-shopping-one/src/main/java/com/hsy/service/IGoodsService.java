package com.hsy.service;

import com.hsy.entity.Goods;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/21 17:48
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public interface IGoodsService {
    /**
     *
     * @description <p>商品列表，有分页功能</p>
     * @returnType List<Goods>
     * 方法名:selectGoodsListOfPage
     * 类名:IGoodsService
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/29 11:57
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    List<Goods> selectGoodsListOfPage(Integer currentPage,Integer pageSize) ;
    /**
     *
     * @description <p></p>
     * @returnType Boolean  是否添加商品成功
     * 方法名:addGoods
     * 类名:IGoodsService
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/29 11:57
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    Boolean addGoods(String name,Double price,Integer number) ;//添加商品
    /**
     *
     * @description <p></p>
     * @returnType Boolean  是否上架下架成功
     * 方法名:
     * 类名:IGoodsService
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/29 13:17
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    Boolean groundingOrUndercarriageGoods(String busineeeType,Integer id) ; // 上架，下架商品
}
