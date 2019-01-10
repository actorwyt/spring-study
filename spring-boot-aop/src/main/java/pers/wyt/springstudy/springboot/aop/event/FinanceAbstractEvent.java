package pers.wyt.springstudy.springboot.aop.event;

import org.springframework.context.ApplicationEvent;

public abstract class FinanceAbstractEvent extends ApplicationEvent {
    private Object[] args;
    private Object retVal;

    public FinanceAbstractEvent(Object source) {
        super(source);
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object getRetVal() {
        return retVal;
    }

    public void setRetVal(Object retVal) {
        this.retVal = retVal;
    }
}
