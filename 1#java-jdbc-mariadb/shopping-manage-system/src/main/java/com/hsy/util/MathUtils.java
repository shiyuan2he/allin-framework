package com.hsy.util;

import java.util.Random;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/19 10:42
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class MathUtils {
    /**
     *
     * @description <p>根据传入的位数生成相应位数的随机数</p>
     * @returnType 生成的随机苏
     * 方法名:
     * 类名:MathUtils
     * @author heshiyuan
     * @email shiyuan4work@sina.com
     * @date 2017/7/25 8:53
     * @price ￥:5毛
     * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
     * @callnumber 15910868535
     */
    public static int generateRandomByLength(int length){
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<length;i++){
            str.append(random.nextInt(10));
        }
        return Integer.parseInt(str.toString());
    }
}
