package org.example.spring.context;

import java.util.EventListener;

/**
 * @Author Roc
 * @Date 2024/11/27 16:38
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
