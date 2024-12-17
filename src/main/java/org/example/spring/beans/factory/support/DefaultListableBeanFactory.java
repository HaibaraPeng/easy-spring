package org.example.spring.beans.factory.support;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.ConfigurableListableBeanFactory;
import org.example.spring.beans.factory.config.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Roc
 * @Date 2024/11/20 15:11
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public DefaultListableBeanFactory() {
        super();
    }

    public DefaultListableBeanFactory(InstantiationStrategy instantiationStrategy) {
        super(instantiationStrategy);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitions.get(name);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + name + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitions.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitions.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitions.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        List<String> beanNames = new ArrayList<>();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitions.entrySet()) {
            Class beanClass = entry.getValue().getBeanClass();
            if (requiredType.isAssignableFrom(beanClass)) {
                beanNames.add(entry.getKey());
            }
        }

        if (beanNames.size() == 1) {
            return getBean(beanNames.get(0), requiredType);
        }

        throw new BeansException(requiredType + " expected single bean but found " + beanNames.size() + ": " + beanNames);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitions.keySet().toArray(new String[0]);
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitions.forEach((beanName, beanDefinition) -> {
            if (beanDefinition.isSingleton()) {
                getBean(beanName);
            }
        });
    }
}
