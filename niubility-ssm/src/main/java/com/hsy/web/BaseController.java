package com.hsy.web;
import com.hsy.dto.ResponseBodyBean;
import com.hsy.enums.ConstantsEnum;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.web
 * @date 18/08/2017 11:05 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BaseController {
    /**
     * @description <p>通用失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:12 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> failure(){
        return new ResponseBodyBean<>(false, ConstantsEnum.RETURN_COMMON_FAILURE.getCode(), ConstantsEnum.RETURN_COMMON_FAILURE.getMsg()) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> failure(String code , String errorInfo){
        return new ResponseBodyBean<>(false, code,errorInfo) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> failure(String errorInfo){
        return new ResponseBodyBean<>(false, ConstantsEnum.RETURN_COMMON_FAILURE.getCode(), ConstantsEnum.RETURN_COMMON_FAILURE.getMsg()) ;
    }
    /**
     * @description <p>通用失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:12 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> success(){
        return new ResponseBodyBean<>(true, ConstantsEnum.RETURN_COMMON_SUCCESS.getCode(), ConstantsEnum.RETURN_COMMON_SUCCESS.getMsg()) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> success(Object obj){
        return new ResponseBodyBean<>(true, ConstantsEnum.RETURN_COMMON_SUCCESS.getCode(),obj) ;
    }
}
