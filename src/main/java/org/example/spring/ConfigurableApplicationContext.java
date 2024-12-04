package org.example.spring;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.context.ApplicationContext;

/**
 * @Author Roc
 * @Date 2024/11/23 16:23
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;

    void close();

    void registerShutdownHook();
}
