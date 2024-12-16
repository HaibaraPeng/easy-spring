package org.example.spring.common.event;

import org.example.spring.context.ApplicationListener;
import org.example.spring.context.event.ContextRefreshedEvent;

/**
 * @Author Roc
 * @Date 2024/11/28 15:29
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
