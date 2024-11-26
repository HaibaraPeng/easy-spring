package org.example.spring.beans.factory.service;

import lombok.Getter;
import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.BeanFactory;
import org.example.spring.beans.factory.BeanFactoryAware;
import org.example.spring.context.ApplicationContext;
import org.example.spring.context.ApplicationContextAware;

/**
 * @Author Roc
 * @Date 2024/11/20 15:16
 */
@Getter
public class HelloService implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
