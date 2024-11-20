package org.example.spring.beans.factory.support;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Roc
 * @Date 2024/11/20 11:04
 */
@Getter
@Setter
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

}
