package com.hsy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/24 15:13
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Constant {
    public static ThreadLocal<HttpServletRequest> requestThreadLocal = null;

    public static ThreadLocal<HttpServletResponse> responseThreadLocal = null;
}
