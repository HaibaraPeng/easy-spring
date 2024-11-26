package org.example.spring.context.support;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.config.BeanPostProcessor;
import org.example.spring.context.ApplicationContext;
import org.example.spring.context.ApplicationContextAware;

/**
 * @Author Roc
 * @Date 2024/11/26 15:07
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
