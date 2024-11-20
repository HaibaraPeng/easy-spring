package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeanException;

/**
 * @Author Roc
 * @Date 2024/11/20 11:55
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private final InstantiationStrategy instantiationStrategy;

    public AbstractAutowireCapableBeanFactory(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name, beanDefinition);
    }

    private Object doCreateBean(String name, BeanDefinition beanDefinition) {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition);
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }
        addSingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) {
        return instantiationStrategy.instantiate(beanDefinition);
    }
}
