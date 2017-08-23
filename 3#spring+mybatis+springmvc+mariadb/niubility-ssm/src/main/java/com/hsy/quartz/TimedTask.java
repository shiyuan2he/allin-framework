package com.hsy.quartz;

import com.hsy.cache.RedisCache;
import com.hsy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.quartz
 * @date 23/08/2017 11:33 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Component
public class TimedTask {
    private final static Logger _logger = LoggerFactory.getLogger(TimedTask.class) ;

    @Autowired
    IUserService userService ;
    @Autowired
    RedisCache redisCache ;
    /**
     * @description <p>每天上午9点到下午17点，每隔三分钟给用户添加1积分</p>
     * @author heshiyuan
     * @date 23/08/2017 11:45 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Scheduled(cron = "0 0/3 9-17 * * ? ")
    public void addScore(){
        _logger.info("每3分钟给每个用户添加1积分");
        userService.addScore(1);
    }
    /**
     * @description <p>每一小时清理一次redis缓存</p>
     * @author heshiyuan
     * @date 23/08/2017 11:45 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void clearRedisCache(){
        _logger.info("每十分钟清理redis缓存");
        redisCache.clearCache();
    }
}
