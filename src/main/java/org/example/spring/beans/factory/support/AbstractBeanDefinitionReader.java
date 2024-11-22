package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeanException;
import org.example.spring.core.io.DefaultResourceLoader;
import org.example.spring.core.io.Resource;
import org.example.spring.core.io.ResourceLoader;

/**
 * @Author Roc
 * @Date 2024/11/22 15:40
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws BeanException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }
}
