package org.example.spring.beans.factory.config;

import org.example.spring.beans.exception.BeansException;

/**
 * 用于修改实例化后的bean的修改扩展点
 *
 * @Author Roc
 * @Date 2024/11/23 13:59
 */
public interface BeanPostProcessor {

    /**
     * 在bean执行初始化方法之前执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
