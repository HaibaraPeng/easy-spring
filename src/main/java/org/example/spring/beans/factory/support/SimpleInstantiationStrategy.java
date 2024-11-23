package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author Roc
 * @Date 2024/11/20 15:44
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
