package com.hsy.dao;

import com.hsy.entity.GoodsSalesperson;

import java.util.List;

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
    List<GoodsSalesperson> dailyGsales() ;
    boolean shoppingSettlement(GoodsSalesperson goodsSalesperson);
}
