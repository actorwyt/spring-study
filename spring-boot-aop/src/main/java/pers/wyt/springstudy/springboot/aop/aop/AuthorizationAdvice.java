package pers.wyt.springstudy.springboot.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import pers.wyt.springstudy.springboot.aop.annotation.AuthorizationAnnotation;
import pers.wyt.springstudy.springboot.aop.exception.CheckedException;
import pers.wyt.springstudy.springboot.aop.service.AuthService;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @Author: wanyutong
 * @Date: 2019/1/7
 * @Description:
 */
@Component
@Aspect
public class AuthorizationAdvice {

    @Resource
    private AuthService authService;

    @Around(value = "execution(* pers.wyt.springstudy.springboot.aop.controller.*.*(..))")
    public Object afterReturning(ProceedingJoinPoint pjp) throws Throwable {
        Object [] args = pjp.getArgs();
        System.out.println(pjp.getArgs());
        //用户拥有的权限
        Set<String> roles = authService.currentUserRoles();
        //System.out.println(roles);
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        AuthorizationAnnotation annotation = method.getAnnotation(AuthorizationAnnotation.class);
        boolean authorized = true;
        if (annotation != null) {
            authorized = false;

            String[] needRoles = annotation.roles();

            for (String r : needRoles) {
                if (CollectionUtils.isEmpty(roles)){
                    break;
                }
                if (roles.contains(r)) {
                    authorized = true;
                    break;
                }
            }
        }
        if (!authorized) {
            //throw new AccessDeniedException("没有权限");
            throw new CheckedException("没有权限");
        }
        return pjp.proceed();
    }
}
