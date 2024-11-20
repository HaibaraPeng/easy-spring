package org.example.spring.beans.factory;

import org.example.spring.beans.factory.support.BeanDefinition;
import org.example.spring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    @Test
    void getBean() {
        beanFactory.registerBeanDefinition("helloService", new BeanDefinition(HelloService.class));
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertNotNull(helloService);
        assertEquals("hello", helloService.sayHello());
    }

}