package pers.wyt.springstudy.springboot.aop.utils;


/**
 * @Author: wanyutong
 * @Date: 2018/9/4
 * @Description:
 */
public abstract class ReturnCode {
    /**
     * 成功统一返回 10200
     */
    public static final int OKAY = 10200;

    /**
     * 未登录
     */
    public static final int UNAUTHORIZED = 10100;

    /**
     * 无权限
     */
    public static final int FORBIDDEN = 10600;

    /**
     * 无此资源
     */
    public static final int NOT_FOUND = 10300;

    /**
     * 客户端输入错误
     */
    public static final int BAD_REQUEST = 10400;

    /**
     * 服务端异常
     */
    public static final int SERVER_ERROR = 10500;

    /**
     * CheckedException异常，用户操作有误
     */
    public static final int CHECKED_ERROR = 10700;

    /**
     * 其他自定义错误码
     */


    private ReturnCode() {
    }
}
