package com.hsy.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.exception
 * @date 23/08/2017 1:21 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String prefix = "NB" ;
    private String code ;
    private String message ;
    public BusinessException(String code,String msg){
        super(msg);
        this.code = code ;
        this.message = msg ;
    }
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        if(StringUtils.isBlank(code)){
            return prefix+"9999" ;
        }else{
            return code;
        }
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
