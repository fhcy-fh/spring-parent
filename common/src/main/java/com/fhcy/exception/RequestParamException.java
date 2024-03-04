package com.fhcy.exception;

import com.fhcy.enums.ResultCodeEnum;

public class RequestParamException extends RuntimeException {

    private String code;
    private String fieldName;

    public RequestParamException(String msg) {
        this(ResultCodeEnum.PARAM_ERROR.getCode(), msg, null);
    }

    public RequestParamException(String code, String msg) {
        this(code, msg, null);
    }

    public RequestParamException(String code, String msg, String fieldName) {
        super(msg);
        this.code = code;
        this.fieldName = fieldName;
    }

    public String getCode() {
        return code;
    }

    public String getFieldName() {
        return fieldName;
    }
}