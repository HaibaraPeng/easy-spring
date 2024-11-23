package org.example.spring.beans.factory.common;

import org.example.spring.beans.PropertyValue;
import org.example.spring.beans.PropertyValues;
import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.ConfigurableListableBeanFactory;
import org.example.spring.beans.factory.config.BeanDefinition;
import org.example.spring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author Roc
 * @Date 2024/11/23 15:11
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition personBeanDefinition = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = personBeanDefinition.getPropertyValues();
        //将person的name属性改为ivy
        propertyValues.addPropertyValue(new PropertyValue("name", "roc"));
    }
}
