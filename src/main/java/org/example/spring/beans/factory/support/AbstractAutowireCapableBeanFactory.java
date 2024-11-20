package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeanException;

/**
 * @Author Roc
 * @Date 2024/11/20 11:55
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name, beanDefinition);
    }

    private Object doCreateBean(String name, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean;
        try {
            bean = beanClass.newInstance();
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }
        addSingleton(name, bean);
        return bean;
    }
}
