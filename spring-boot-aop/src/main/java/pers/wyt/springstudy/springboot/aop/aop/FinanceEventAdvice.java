package pers.wyt.springstudy.springboot.aop.aop;

import com.netease.hz.springbootaop.annotation.FinanceEventAnnotation;
import com.netease.hz.springbootaop.event.FinanceAbstractEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 定义切面，抛出切面
 * Created by minghua.zmh on 2018/12/5.
 */
@Component
@Aspect
public class FinanceEventAdvice implements ApplicationEventPublisherAware {
    private Logger logger = LoggerFactory.getLogger(FinanceEventAdvice.class);
    private ApplicationEventPublisher publisher;

    @AfterReturning(pointcut = "@annotation(com.netease.hz.springbootaop.annotation.FinanceEventAnnotation)",returning = "retval")

    public void afterReturning(JoinPoint jp, Object retval) {
        Object[] args = jp.getArgs();


        MethodSignature signature = (MethodSignature)jp.getSignature();
        Method method = signature.getMethod();

        FinanceEventAnnotation annotation = method.getAnnotation(FinanceEventAnnotation.class);
        Class<? extends FinanceAbstractEvent> eventClass = annotation.eventClass();

        //获取核心参数的值
        Integer parameterIndex = Integer.valueOf(annotation.idIndex());
        Object arg = args[parameterIndex];
        if (arg == null) {
            logger.error("无效的消息体");
            return;
        }

        //抛出事件
        FinanceAbstractEvent ins;
        try {
            ins = eventClass.getDeclaredConstructor(arg.getClass()).newInstance(arg);
            ins.setArgs(args);
            ins.setRetVal(retval);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return;
        }
        publisher.publishEvent(ins);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
