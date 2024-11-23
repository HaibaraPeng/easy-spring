package org.example.spring.beans.factory;

import org.example.spring.beans.exception.BeansException;

/**
 * @Author Roc
 * @Date 2024/11/20 10:39
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
