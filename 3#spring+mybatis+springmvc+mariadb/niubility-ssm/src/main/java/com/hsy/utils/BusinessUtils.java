package com.hsy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hsy.bean.entity.User;
import com.hsy.dto.RequestBodyBean;
import com.hsy.javase.json.JsonHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.utils
 * @date 18/08/2017 11:59 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BusinessUtils {
    private final static Logger _logger = LoggerFactory.getLogger(BusinessUtils.class) ;
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 1:09 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static <T> T requestJsonToBean(String json,Class<T> clazz){
        if(null == json || "".equals(json)) return  null;
        try{
            RequestBodyBean<T> requestBody =  JSON.parseObject(json,new TypeReference<RequestBodyBean>(){}) ;
            T params = requestBody.getParam();
            return params;
        }catch(Exception e){
            _logger.error("请求参数解析错误,json数据是:{}",json);
        }
        return null ;
    }
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 1:09 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String requestBeanToJson(Object obj){
        return JsonHelper.obj2Json(obj) ;
    }
    public static boolean validateParamForRegister(User user){
        if(StringUtils.isNotBlank(user.getName())
                && StringUtils.isNotBlank(user.getPassword())
                && StringUtils.isNotBlank(user.getSex())
                && null != user.getTel()){
            return true ;
        }
        return false ;
    }
}
