package org.example.spring.context.event;

import org.example.spring.context.ApplicationContext;

/**
 * @Author Roc
 * @Date 2024/12/4 15:22
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
}
