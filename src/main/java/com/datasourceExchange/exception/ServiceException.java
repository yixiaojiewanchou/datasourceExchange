package com.datasourceExchange.exception;

public class ServiceException extends RuntimeException {
    private Integer code;

    public ServiceException() {
        super();
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ServiceEnum serviceEnum) {
        this(serviceEnum.getCode(), serviceEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
