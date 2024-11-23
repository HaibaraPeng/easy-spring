package org.example.spring.beans.factory;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.example.spring.beans.factory.config.BeanDefinition;
import org.example.spring.beans.factory.config.BeanPostProcessor;
import org.example.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author Roc
 * @Date 2024/11/23 11:09
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
