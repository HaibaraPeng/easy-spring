package org.example.spring.beans.factory;

import org.example.spring.beans.factory.config.BeanDefinition;
import org.example.spring.beans.factory.support.CglibInstantiationStrategy;
import org.example.spring.beans.factory.support.DefaultListableBeanFactory;
import org.example.spring.beans.factory.support.SimpleInstantiationStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {

    @Test
    void getBeanBySimpleInstantiationStrategy() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(new SimpleInstantiationStrategy());
        beanFactory.registerBeanDefinition("helloService", new BeanDefinition(HelloService.class));
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertNotNull(helloService);
        assertEquals("hello", helloService.sayHello());
    }

    @Test
    void getBeanByCglibInstantiationStrategy() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(new CglibInstantiationStrategy());
        beanFactory.registerBeanDefinition("helloService", new BeanDefinition(HelloService.class));
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertNotNull(helloService);
        assertEquals("hello", helloService.sayHello());
    }

}