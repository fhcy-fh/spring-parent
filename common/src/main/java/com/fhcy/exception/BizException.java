package com.fhcy.exception;

import com.fhcy.enums.ResultCodeEnum;

public class BizException extends RuntimeException {

    private String code;

    /**
     * @param message 异常消息
     */
    public BizException(String message) {
        this(ResultCodeEnum.FAILED.getCode(), message);
    }

    /**
     * @param code    异常代码
     * @param message 异常消息
     */
    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}