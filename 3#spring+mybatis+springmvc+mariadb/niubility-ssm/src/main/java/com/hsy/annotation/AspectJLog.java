package com.hsy.annotation;

import java.lang.annotation.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.annotation
 * @date 23/08/2017 4:04 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectJLog {
    boolean saveToDb() default false;
    String description() default "";
}
