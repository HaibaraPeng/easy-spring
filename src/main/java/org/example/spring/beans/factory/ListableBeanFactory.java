package org.example.spring.beans.factory;

import org.example.spring.beans.exception.BeansException;

import java.util.Map;

/**
 * @Author Roc
 * @Date 2024/11/23 11:09
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
