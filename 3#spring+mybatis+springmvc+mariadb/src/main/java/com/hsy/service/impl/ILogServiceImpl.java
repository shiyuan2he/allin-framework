package com.hsy.service.impl;

import com.hsy.bean.entity.Log;
import com.hsy.dao.ILogDao;
import com.hsy.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.service.impl
 * @date 23/08/2017 4:34 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("logService")
public class ILogServiceImpl implements ILogService {
    @Autowired
    ILogDao iLogDao ;
    @Override
    public int saveLog(Log log) {
        return iLogDao.saveLog(log);
    }
}
