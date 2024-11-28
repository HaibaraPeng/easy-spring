package org.example.spring.context.event;

import org.example.spring.context.ApplicationContext;
import org.example.spring.context.ApplicationEvent;

/**
 * @Author Roc
 * @Date 2024/11/28 15:27
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(ApplicationContext source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
