package org.example.spring.beans.factory.xml;

import org.example.spring.bean.Car;
import org.example.spring.bean.Person;
import org.example.spring.beans.factory.support.DefaultListableBeanFactory;
import org.example.spring.beans.factory.support.SimpleInstantiationStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Roc
 * @Date 2024/11/22 17:13
 */
public class XmlFileDefineBeanTest {

    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(new SimpleInstantiationStrategy());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertEquals(person.getName(), "derek");
        assertEquals(person.getCar().getBrand(), "porsche");

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        assertEquals(car.getBrand(), "porsche");
    }
}
