package org.example.spring.beans.factory.support;

/**
 * @Author Roc
 * @Date 2024/11/20 11:21
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
