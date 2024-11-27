package org.example.spring.context.event;

import org.example.spring.context.ApplicationEvent;
import org.example.spring.context.ApplicationListener;

/**
 * @Author Roc
 * @Date 2024/11/27 16:58
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
