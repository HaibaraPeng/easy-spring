package org.example.spring.beans.factory;

/**
 * @Author Roc
 * @Date 2024/11/27 15:38
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
