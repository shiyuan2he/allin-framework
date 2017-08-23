package com.hsy.exception;

import com.alibaba.fastjson.JSON;
import com.hsy.dto.ResponseBodyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author heshiyuan
 * @description <p>全局异常统一处理</p>
 * @path framework/com.hsy.exception
 * @date 23/08/2017 1:28 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Component
public class GlobalException implements HandlerExceptionResolver{
    private final Logger _logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //这里有2种选择
        //跳转到定制化的错误页面
	    ModelAndView error = new ModelAndView();
        error.setViewName("/error/500");
		error.addObject("code", ((BusinessException) ex).getCode());
		error.addObject("message", ex.getMessage());
        //返回json格式的错误信息
        /*try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            String responseStr = JSON.toJSONString(new ResponseBodyBean<>(false,((BusinessException) ex).getCode(),ex.getMessage())) ;
            _logger.info("全局异常处理返回信息：{}",responseStr);
            writer.write(responseStr);
            writer.flush();
        } catch (Exception e) {
            _logger.error("全局处理异常失败,message:{}:",e.getMessage());
        }*/
        return error;
    }
}
