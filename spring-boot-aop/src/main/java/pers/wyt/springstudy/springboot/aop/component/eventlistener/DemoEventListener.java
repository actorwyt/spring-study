package pers.wyt.springstudy.springboot.aop.component.eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pers.wyt.springstudy.springboot.aop.event.DemoEvent;
import pers.wyt.springstudy.springboot.aop.event.FinanceAbstractEvent;

/**
 * @Author: wanyutong
 * @Date: 2019/1/9
 * @Description:
 */
@Component
public class DemoEventListener {

    @EventListener(value = {DemoEvent.class})
    public void handleEvent(FinanceAbstractEvent event) {
        System.out.println(event.getArgs());
    }
}
