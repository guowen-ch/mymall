package com.gwen.mall.utils;


public class ResultInfo<T> {
    private long code;
    private String msg;
    private T data;

    protected ResultInfo() {
    }

    protected ResultInfo(long code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultInfo<T> success(T data) {
        return new ResultInfo<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResultInfo<T> success(T data, String message) {
        return new ResultInfo<T>(ResultCode.SUCCESS.getCode(), message, data);
    }


    public static <T> ResultInfo<T> success( String message) {
        return new ResultInfo<T>(ResultCode.SUCCESS.getCode(), message,null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResultInfo<T> failed(IErrorCode errorCode) {
        return new ResultInfo<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultInfo<T> failed(String message) {
        return new ResultInfo<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultInfo<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultInfo<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultInfo<T> validateFailed(String message) {
        return new ResultInfo<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResultInfo<T> unauthorized(T data) {
        return new ResultInfo<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultInfo<T> forbidden(T data) {
        return new ResultInfo<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
