package com.hsy.aop;

import com.alibaba.fastjson.JSONObject;
import com.hsy.annotation.AspectJLog;
import com.hsy.bean.entity.Log;
import com.hsy.javase.utils.MathHelper;
import com.hsy.service.ILogService;
import com.hsy.thread.LogThread;
import com.hsy.thread.pool.FixedThreadPool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Date;

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
@Component
@Aspect
public class LogAspectJ {
    private final static Logger _logger = LoggerFactory.getLogger(LogAspectJ.class) ;
    @Autowired
    FixedThreadPool fixedThreadPool ;
    @Autowired
    ILogService logService ;

    @Pointcut("execution(* com.hsy.web.*.*(..))")
    public void aopMethod(){}

    @Around("aopMethod()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        _logger.info("【切面日志】环绕切面。。。");
    }

    @Pointcut("@annotation(com.hsy.annotation.AspectJLog)")
    public void methodCachePointcut() {}

    @Around("methodCachePointcut() && @annotation(aspectJLog)")
    public Object methodCacheHold(ProceedingJoinPoint joinPoint,AspectJLog aspectJLog) throws Throwable {
        Object obj = null;
        // 获取调用方法的参数
        Object[] args = joinPoint.getArgs();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            saveLogToDB(joinPoint,aspectJLog, args, null, e);
            _logger.error(e.getMessage(),e);
            throw e;
        }
        saveLogToDB(joinPoint,aspectJLog, args, obj, null);
        return obj ;

    }

    private void saveLogToDB(ProceedingJoinPoint joinPoint,AspectJLog aspectJLog,Object[] args, Object obj, Throwable e) throws Throwable {
        if(null == aspectJLog){
            aspectJLog = getAspectJLog(joinPoint, args);
        }
        if(null!=aspectJLog&&aspectJLog.saveToDb()){
            //接下来是入库操作
            Log log = new Log() ;
            log.setRequestTime(new Date());
            log.setId(MathHelper.generateRandomOfLongByLength(18));
            log.setRequestAction(aspectJLog.description());
            log.setRequestUrl(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
            if(null!=e){
                log.setRequestResponse(JSONObject.toJSONString(e.getStackTrace()));
            }else{
                log.setRequestResponse(JSONObject.toJSONString(obj));
            }
            //此处 submit跟execute的区别
            fixedThreadPool.getFixedThreadPool().submit(new LogThread(log,logService)) ;
        }
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
    private AspectJLog getAspectJLog(ProceedingJoinPoint joinPoint, Object[] args) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == args.length) {
                    return method.getAnnotation(AspectJLog.class);
                }
            }
        }
        return null;
    }
}
