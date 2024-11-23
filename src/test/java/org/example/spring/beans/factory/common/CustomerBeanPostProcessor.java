package org.example.spring.beans.factory.common;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.bean.Car;
import org.example.spring.beans.factory.config.BeanPostProcessor;

/**
 * @Author Roc
 * @Date 2024/11/23 15:22
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization");
        //换兰博基尼
        if ("car".equals(beanName)) {
            ((Car) bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }
}
