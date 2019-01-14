package pers.wyt.springstudy.springboot.aop.utils;

import java.io.Serializable;

/**
 * @Author: wanyutong
 * @Date: 2018/9/4
 * @Description:
 */
public class StandardResponseBody<T> implements Serializable {
    private int retCode;
    private String retDesc;
    private T result;

    public StandardResponseBody() {
    }

    public StandardResponseBody(int retCode) {
        this.retCode = retCode;
    }

    public StandardResponseBody(int retCode, String retDesc, T result) {
        this.retCode = retCode;
        this.retDesc = retDesc;
        this.result = result;
    }

    /**
     * 没有数据
     */
    public static <D> StandardResponseBody<D> notFound() {
        return new StandardResponseBody<>(ReturnCode.NOT_FOUND, "数据不存在", null);
    }

    public static <D> StandardResponseBody<D> notFound(String msg) {
        return new StandardResponseBody<>(ReturnCode.NOT_FOUND, msg, null);
    }

    /**
     * 没有权限, 禁止访问
     */
    public static <D> StandardResponseBody<D> forbidden() {
        return new StandardResponseBody<>(ReturnCode.FORBIDDEN, "没有权限", null);
    }

    public static <D> StandardResponseBody<D> forbidden(String msg) {
        return new StandardResponseBody<>(ReturnCode.FORBIDDEN, msg, null);
    }

    /**
     * 未登录或登录过期
     */
    public static <D> StandardResponseBody<D> unauthorized() {
        return new StandardResponseBody<>(ReturnCode.UNAUTHORIZED, "未登录", null);
    }

    /**
     * 未登录或登录过期
     */
    public static <D> StandardResponseBody<D> unauthorized(String desc) {
        return new StandardResponseBody<>(ReturnCode.UNAUTHORIZED, desc, null);
    }

    /**
     * 客户端异常
     */
    public static StandardResponseBody<?> badRequest() {
        return new StandardResponseBody<>(ReturnCode.BAD_REQUEST, "参数错误", null);
    }

    /**
     * 客户端异常
     */
    public static StandardResponseBody<?> badRequest(String desc) {
        return new StandardResponseBody<>(ReturnCode.BAD_REQUEST, desc, null);
    }

    /**
     * 服务端异常
     */
    public static StandardResponseBody<?> serverError() {
        return new StandardResponseBody<>(ReturnCode.SERVER_ERROR, "系统故障，请稍后再试", null);
    }

    public static StandardResponseBody<?> serverError(String message) {
        return new StandardResponseBody<>(ReturnCode.CHECKED_ERROR, message, null);
    }


    /**
     * 正常
     */
    public static StandardResponseBody<?> ok() {
        return ok(null);
    }

    /**
     * 正常
     *
     * @param result 正常返回的数据
     */
    public static <D> StandardResponseBody<D> ok(D result) {
        return new StandardResponseBody<>(ReturnCode.OKAY, "", result);
    }

    /**
     * 正常
     *
     * @param result 正常返回的数据
     */
    public static <D> StandardResponseBody<D> ok(D result, String warningMsg) {
        return new StandardResponseBody<>(ReturnCode.OKAY, warningMsg, result);
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
