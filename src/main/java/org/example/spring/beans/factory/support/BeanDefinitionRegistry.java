package org.example.spring.beans.factory.support;

/**
 * @Author Roc
 * @Date 2024/11/20 15:10
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
