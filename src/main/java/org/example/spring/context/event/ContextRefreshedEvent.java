package org.example.spring.context.event;

import org.example.spring.context.ApplicationContext;

/**
 * @Author Roc
 * @Date 2024/11/28 15:20
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
}
