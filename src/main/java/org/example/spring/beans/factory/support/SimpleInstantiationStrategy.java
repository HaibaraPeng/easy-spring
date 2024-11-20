package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeanException;

import java.lang.reflect.Constructor;

/**
 * @Author Roc
 * @Date 2024/11/20 15:44
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeanException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeanException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
