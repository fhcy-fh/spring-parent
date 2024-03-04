package com.fhcy.result;

import com.fhcy.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private boolean success;
    private String status;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        ResultCodeEnum success = ResultCodeEnum.SUCCESS;
        return success(success.getCode(), success.getMsg(), null);
    }

    public static <T> Result<T> success(T data) {
        return success(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        ResultCodeEnum success = ResultCodeEnum.SUCCESS;
        message = StringUtils.isBlank(message) ? success.getMsg() : message;
        return success(success.getCode(), message, data);
    }

    public static <T> Result<T> success(String status, String message, T data) {
        return new Result<>(true, status, message, data);
    }

    public static <T> Result<T> failed() {
        ResultCodeEnum failed = ResultCodeEnum.FAILED;
        return failed(failed.getCode(), failed.getMsg(), null);
    }

    public static <T> Result<T> failed(String message) {
        return failed(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    public static <T> Result<T> failed(String message, T data) {
        ResultCodeEnum failed = ResultCodeEnum.FAILED;
        message = StringUtils.isBlank(message) ? failed.getMsg() : message;
        return failed(failed.getCode(), message, data);
    }

    public static <T> Result<T> failed(String status, String message, T data) {
        return new Result<>(false, status, message, data);
    }
}
