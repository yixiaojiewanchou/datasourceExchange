package com.datasourceExchange.exception;

/**
 * 业务异常都在这里，从1001开始
 */
public enum ServiceEnum {
    ERROR_1001(1001,"传入的id为空"),
    ERROR_1002(1002,"参数格式不正确");


    private Integer code;
    private String msg;

    ServiceEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
