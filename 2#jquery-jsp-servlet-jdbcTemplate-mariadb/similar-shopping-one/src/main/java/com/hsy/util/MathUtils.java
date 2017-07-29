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
