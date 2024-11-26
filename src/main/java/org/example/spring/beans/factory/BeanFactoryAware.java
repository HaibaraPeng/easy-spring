package org.example.spring.beans.factory;

import org.example.spring.beans.exception.BeansException;

/**
 * @Author Roc
 * @Date 2024/11/26 14:33
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
