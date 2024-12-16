package org.example.spring.common.event;

import org.example.spring.context.ApplicationContext;
import org.example.spring.context.event.ApplicationContextEvent;

/**
 * @Author Roc
 * @Date 2024/11/28 16:17
 */
public class CustomEvent extends ApplicationContextEvent {

    public CustomEvent(ApplicationContext source) {
        super(source);
    }
}
