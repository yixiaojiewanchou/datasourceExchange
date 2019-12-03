package com.datasourceExchange.exception;

import com.datasourceExchange.util.ResultVOUtil;
import com.datasourceExchange.vo.ResultVO;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ServiceExceptionHandler {
    private static final Logger log = Logger.getLogger(ServiceExceptionHandler.class);

    private static Map<String,String> exceptionMap=new HashMap<>();

    //枚举常见异常类
    static {
        for(ResultEnum resultEnum:ResultEnum.values()){
            exceptionMap.put(resultEnum.getException(),resultEnum.getMsg());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handlerException(Exception e){
        log.error("异常开始捕捉{}",e);

        //业务异常
        if(e instanceof ServiceException){
            ServiceException ee=(ServiceException) e;
            return ResultVOUtil.error(ee.getCode(),ee.getMessage());
        }

        //系统异常
        String msg=exceptionMap.get(e.getClass().getName());
        if(!StringUtils.isEmpty(msg)){
            return ResultVOUtil.error(500,msg);
        }else {
            return ResultVOUtil.error(500,"未知错误,请联系管理员！");
        }
    }

}
