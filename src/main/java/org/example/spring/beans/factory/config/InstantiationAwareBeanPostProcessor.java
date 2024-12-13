package org.example.spring.beans.factory.config;

import org.example.spring.beans.exception.BeansException;

/**
 * @Author Roc
 * @Date 2024/12/11 17:15
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在bean执行初始化方法之前执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
