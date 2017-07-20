package com.hsy.dao;

import com.hsy.entity.GoodsSalesperson;

import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao
 * @date 2017/7/15 下午6:00
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IGoodsSalespersonDao {
    /**
     * 
     * @description <p>显示已经卖出的产品</p>
     * @returnType List<Map<String,Object>> 
     * 方法名:dailyGsales
     * 类名:IGoodsSalespersonDao
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/20 10:59
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    List<Map<String,Object>> dailyGsales() ;
    /**
     * 
     * @description <p>添加卖出的商品</p>
     * @returnType boolean 添加商品是否成功
     * 方法名:
     * 类名:IGoodsSalespersonDao
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/20 10:59
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    boolean shoppingSettlement(GoodsSalesperson goodsSalesperson);
}
