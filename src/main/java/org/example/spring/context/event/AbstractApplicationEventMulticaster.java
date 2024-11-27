package org.example.spring.context.event;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.BeanFactory;
import org.example.spring.beans.factory.BeanFactoryAware;
import org.example.spring.context.ApplicationEvent;
import org.example.spring.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Roc
 * @Date 2024/11/27 16:59
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }
}
