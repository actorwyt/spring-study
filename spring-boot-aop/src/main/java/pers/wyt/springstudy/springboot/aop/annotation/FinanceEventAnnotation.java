package pers.wyt.springstudy.springboot.aop.annotation;


import pers.wyt.springstudy.springboot.aop.event.FinanceAbstractEvent;

import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface FinanceEventAnnotation {
    //事件类型
    @NotNull
    Class<? extends FinanceAbstractEvent> eventClass();

    String idIndex() default "";
}


