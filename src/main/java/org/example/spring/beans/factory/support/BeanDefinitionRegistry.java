package org.example.spring.beans.factory.support;

import org.example.spring.beans.factory.config.BeanDefinition;

/**
 * @Author Roc
 * @Date 2024/11/20 15:10
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
