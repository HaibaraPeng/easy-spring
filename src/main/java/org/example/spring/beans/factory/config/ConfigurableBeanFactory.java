package org.example.spring.beans.factory.config;

import org.example.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @Author Roc
 * @Date 2024/11/23 11:13
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例bean
     */
    void destroySingletons();
}
