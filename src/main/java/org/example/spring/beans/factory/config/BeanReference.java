package org.example.spring.beans.factory.config;

import lombok.Getter;

/**
 * 一个bean对另一个bean的引用
 *
 * @Author Roc
 * @Date 2024/11/21 11:50
 */
@Getter
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

}
