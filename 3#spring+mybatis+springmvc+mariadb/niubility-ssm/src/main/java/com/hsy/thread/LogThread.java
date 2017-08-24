package com.hsy.thread;

import com.hsy.bean.entity.Log;
import com.hsy.enums.Constants;
import com.hsy.exception.BusinessException;
import com.hsy.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.thread
 * @date 23/08/2017 5:38 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class LogThread implements Runnable {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    Log log ;
    ILogService logService ;

    public LogThread(Log log,ILogService logService ){
        this.log = log ;
        this.logService = logService ;
    }
    @Override
    public void run() {
        _logger.info("正在将{}日志信息存进数据库当中！","{"+log.toString()+"}");
        try{
            if(logService.saveLog(log) < 1){
                _logger.info("保存日志没有成功！");
            }else{
                _logger.info("保存日志成功！");
            }
        }catch(Exception e){
            _logger.info("保存日志出现异常！");
            throw new BusinessException(Constants.DB_INSERT_RESULT_ERROR.getCode(),Constants.DB_INSERT_RESULT_ERROR.getMsg());
        }
    }
}
