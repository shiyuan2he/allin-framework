package com.hsy.dao;

import com.hsy.entity.Salesperson;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.dao
 * @date 2017/7/15 下午5:59
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ISalespersonDao {
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 2017/7/16 下午11:24
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    List<Salesperson> queryAllSalespersonList() ;

    int addSalesperson(Salesperson salesperson);

    List<Salesperson> querySalespersonList(String name) ;

    int updateSalesperson(int key,Salesperson salesperson);

    int deleteSalesperson(String name);
    List<Salesperson> checkstandLog(String sName) ;
}
