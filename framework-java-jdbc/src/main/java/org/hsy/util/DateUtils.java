package org.hsy.util;

import java.sql.Timestamp;

/**
 * @author heshiyuan
 * @description <p>时间格式工具类</p>
 * @date 2017/7/20 10:31
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class DateUtils {
    /**
     *
     * @description <p></p>
     * @returnType Timestamp    数据库支持的时间类型
     * 方法名:
     * 类名:DateUtils
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/20 10:58
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public static Timestamp getCurrentTimestamp(){
        return new java.sql.Timestamp(System.currentTimeMillis());
    }
}
