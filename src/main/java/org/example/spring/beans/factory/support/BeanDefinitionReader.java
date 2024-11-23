package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.core.io.Resource;
import org.example.spring.core.io.ResourceLoader;

/**
 * @Author Roc
 * @Date 2024/11/21 16:22
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}
