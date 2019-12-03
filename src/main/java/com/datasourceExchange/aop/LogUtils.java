package com.datasourceExchange.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * 在方法前后打印日志
 */
public class LogUtils {

    private static final Logger log= Logger.getLogger(LogUtils.class);

    public void before(JoinPoint joinPoint){
        log.info("-----方法执行前打印------");
    }

    public void after(JoinPoint joinPoint){
        log.info("-----方法执行后打印------");
    }
}
