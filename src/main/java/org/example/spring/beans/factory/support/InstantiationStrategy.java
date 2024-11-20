package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeanException;

/**
 * @Author Roc
 * @Date 2024/11/20 15:43
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeanException;
}
