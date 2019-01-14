package pers.wyt.springstudy.springboot.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import pers.wyt.springstudy.springboot.aop.exception.CheckedException;
import pers.wyt.springstudy.springboot.aop.service.AuthService;
import pers.wyt.springstudy.springboot.aop.utils.StandardResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Author: wanyutong
 * @Description: 统一异常处理
 */
@ControllerAdvice
public class ControllerExceptionHandlingAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlingAdvice.class);

    @Autowired
    private AuthService authService;

    @ResponseBody
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
    })
    public StandardResponseBody<?> badRequest(HttpServletRequest request, MethodArgumentNotValidException e) {
        //logger.error("user [{}] send a bad request to {}: {}", authService.currentUser(), request.getRequestURI(), e.getMessage());
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();

        ObjectError error = allErrors.stream()
                .findFirst()
                .orElse(new ObjectError("", "参数错误"));

        return StandardResponseBody.badRequest(error.getDefaultMessage());
    }

    /**
     * 400
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            ServletRequestBindingException.class,
            UnsatisfiedServletRequestParameterException.class
    })
    public StandardResponseBody<?> badRequest(HttpServletRequest request, Exception e) {
        //logger.error("user [{}] send a bad request to {}: {}", authService.currentUser(), request.getRequestURI(), e.getMessage());
        return StandardResponseBody.badRequest();
    }

//    /**
//     * 403
//     */
//    @ResponseBody
//    //@ResponseStatus(HttpStatus.FORBIDDEN)
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(AccessDeniedException.class)
//    public StandardResponseBody<?> accessDenied(HttpServletRequest request, AccessDeniedException e) {
//        //logger.error("user [{}] has no privilege to access: {}", authService.currentUser(), request.getRequestURI(), e);
//        return StandardResponseBody.forbidden(e.getMessage());
//    }

    /**
     * 404
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public StandardResponseBody<?> notFound(HttpServletRequest request) {
        //logger.error("user [{}] access nonexistent resource: {}", authService.currentUser(), request.getRequestURI());
        return StandardResponseBody.notFound();
    }

    @ResponseBody
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CheckedException.class)
    public StandardResponseBody<?> customized(HttpServletRequest request, CheckedException e) {
        logger.error("user process error when accessing: {}", request.getRequestURI(), e);
        return StandardResponseBody.serverError(e.getMessage());
    }

    /**
     * 500
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public StandardResponseBody<?> unexpectedError(HttpServletRequest request, Exception e) {
        logger.error("unexpected error when accessing: {}", request.getRequestURI(), e);
        return StandardResponseBody.serverError();
    }


}
