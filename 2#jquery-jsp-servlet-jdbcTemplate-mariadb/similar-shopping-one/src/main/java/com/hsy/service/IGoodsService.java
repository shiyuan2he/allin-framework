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

    List<Goods> selectGoodsListOfPage() ;
}
