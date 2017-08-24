package com.hsy.aop;

import com.alibaba.fastjson.JSONObject;
import com.hsy.annotation.AspectJLogAnnotation;
import com.hsy.bean.entity.Log;
import com.hsy.javase.utils.MathHelper;
import com.hsy.service.ILogService;
import com.hsy.thread.LogThread;
import com.hsy.thread.pool.FixedThreadPool;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.aop
 * @date 23/08/2017 2:54 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Aspect
@Component
public class LogAspectJ {
    private final static Logger _logger = LoggerFactory.getLogger(LogAspectJ.class) ;
    @Autowired
    FixedThreadPool fixedThreadPool ;
    @Autowired
    ILogService logService ;
    /**
     * @description <p>定义一个切面</p>
     * @author heshiyuan
     * @date 24/08/2017 2:39 PM
     */
    @Pointcut("@annotation(com.hsy.annotation.AspectJLogAnnotation)")
    public void methodCachePointcut() {}

    long start = 0,end = 0;
    /**
     * @description <p>前置拦截</p>
     * @author heshiyuan
     * @date 24/08/2017 2:40 PM
     */
    @Before("methodCachePointcut()")
    public void beforeInvokeInterface(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        Object[] args = joinPoint.getArgs();
        _logger.info("调用{}接口开始...参数：{}",method.getName(),Arrays.asList(args)) ;
        start = System.currentTimeMillis() ;
    }

    @Around("methodCachePointcut() && @annotation(aspectJLogAnnotation)")
    public void logAspectJ(ProceedingJoinPoint joinPoint,AspectJLogAnnotation aspectJLogAnnotation) throws Throwable {
        _logger.info("【切面日志】注解切面开始。。。");
        Object obj = null;
        // 获取调用方法的参数
        Object[] args = joinPoint.getArgs();
        long startTime = 0,endTime = 0 ;
        try {
            startTime = System.currentTimeMillis() ;
            obj = joinPoint.proceed(args);
            endTime = System.currentTimeMillis() ;
        } catch (Throwable e) {
            saveLogToDB(joinPoint,aspectJLogAnnotation,(endTime-startTime), args, null, e);
            _logger.error(e.getMessage(),e);
            throw e;
        }
        saveLogToDB(joinPoint,aspectJLogAnnotation, (endTime-startTime),args, obj, null);
        _logger.info("【切面日志】注解切面结束。。。");
    }
    @After("methodCachePointcut()")
    public void afterInvokeInterface(JoinPoint joinPoint){
        MethodSignature signation = (MethodSignature) joinPoint.getSignature() ;
        Method method = signation.getMethod() ;
        end = System.currentTimeMillis() ;
        _logger.info("调用{}接口结束!耗时{}ms",method.getName(),(end - start)) ;
    }
    /*@Around("execution(* com.hsy.web.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        _logger.info("【切面日志】aop拦截切面。。。");
        long startTime = System.currentTimeMillis() ;
        Object obj = null;
        // 获取调用方法的参数
        Object[] args = joinPoint.getArgs();
        long endTime = System.currentTimeMillis() ;
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            saveLogToDB(joinPoint,null,(endTime-startTime), args, null, e);
            _logger.error(e.getMessage(),e);
            throw e;
        }
        saveLogToDB(joinPoint,null, (endTime-startTime),args, obj, null);
    }*/
    private void saveLogToDB(ProceedingJoinPoint joinPoint, AspectJLogAnnotation aspectJLog, long timing, Object[] args, Object obj, Throwable e) throws Throwable {
        if(null == aspectJLog){ // 命名式切面调用专用
            aspectJLog = getAspectJLog(joinPoint, args);
        }
        if(null!=aspectJLog&&aspectJLog.saveToDb()){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //接下来是入库操作
            Log log = new Log() ;
            if(null!=request){
                log.setRequestMethodType(request.getScheme()+"("+request.getMethod()+")");
                log.setRequestIp(request.getServerName());
                log.setRequestUrl(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI());
                //log.setRequestUrl(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
                log.setRequestParam(getRequestParamByArgs(args));
            }
            log.setRequestThreadId(Thread.currentThread().getName()+"-"+String.valueOf(Thread.currentThread().getId()));
            log.setId(MathHelper.generateRandomOfLongByLength(18));
            log.setRequestTime(new Date());
            log.setTiming(String.valueOf(timing));
            log.setRequestAction(aspectJLog.description());
            if(null!=e){
                log.setRequestResponse(JSONObject.toJSONString(e.getStackTrace()));
            }else{
                log.setRequestResponse(JSONObject.toJSONString(obj));
            }
            //此处 submit跟execute的区别
            /**
             * @description <p>
             *                  execute(Runnable x) 没有返回值。可以执行任务，但无法判断任务是否成功完成。
             *                  submit(Runnable x) 返回一个future。可以用这个future来判断任务是否成功完成。
             *              </p>
             * @author heshiyuan
             * @date 24/08/2017 3:38 PM
             */
            fixedThreadPool.getFixedThreadPool().execute(new LogThread(log,logService)) ;
        }
    }

    private String getRequestParamByArgs(Object[] args) {
        List<Object> list = new ArrayList<>() ;
        for(Object obj : args){
            if(obj instanceof String){
                list.add(obj) ;
            }
        }
        String returnStr = list.toString() ;
        return returnStr.substring(1,returnStr.length()-1) ;
    }

    /**
     * @description <p>获取方法上的注解</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 23/08/2017 5:25 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    private AspectJLogAnnotation getAspectJLog(ProceedingJoinPoint joinPoint, Object[] args) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == args.length) {
                    return method.getAnnotation(AspectJLogAnnotation.class);
                }
            }
        }
        return null;
    }
}
