package org.example.spring.context;

/**
 * @Author Roc
 * @Date 2024/11/27 16:41
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
