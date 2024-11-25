package org.example.spring.beans.factory.config;

import lombok.Getter;
import lombok.Setter;
import org.example.spring.beans.PropertyValues;

/**
 * @Author Roc
 * @Date 2024/11/20 11:04
 */
@Getter
@Setter
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

}
