package org.example.spring.common.event;

import org.example.spring.context.ApplicationListener;
import org.example.spring.context.event.ContextClosedEvent;

/**
 * @Author Roc
 * @Date 2024/12/4 15:21
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
