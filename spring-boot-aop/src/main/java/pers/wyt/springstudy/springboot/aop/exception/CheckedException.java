package pers.wyt.springstudy.springboot.aop.exception;

/**
 * @Author: wanyutong
 * @Date: 2018/9/10
 * @Description:
 */
public class CheckedException extends RuntimeException {

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

}
