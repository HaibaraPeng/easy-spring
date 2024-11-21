package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeanException;
import org.example.spring.beans.factory.BeanFactory;
import org.example.spring.beans.factory.config.BeanDefinition;

/**
 * @Author Roc
 * @Date 2024/11/20 11:26
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        return createBean(name, getBeanDefinition(name));
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeanException;
}
