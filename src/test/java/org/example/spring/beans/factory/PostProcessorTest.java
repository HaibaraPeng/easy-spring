package org.example.spring.beans.factory;

import org.example.spring.beans.factory.bean.Car;
import org.example.spring.beans.factory.bean.Person;
import org.example.spring.beans.factory.common.CustomBeanFactoryPostProcessor;
import org.example.spring.beans.factory.common.CustomerBeanPostProcessor;
import org.example.spring.beans.factory.support.DefaultListableBeanFactory;
import org.example.spring.beans.factory.support.SimpleInstantiationStrategy;
import org.example.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Roc
 * @Date 2024/11/23 15:10
 */
public class PostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(new SimpleInstantiationStrategy());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //在所有BeanDefintion加载完成后，但在bean实例化之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostProcessor beanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertEquals(person.getName(), "roc");
    }

    @Test
    public void testBeanPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(new SimpleInstantiationStrategy());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //添加bean实例化后的处理器
        CustomerBeanPostProcessor customerBeanPostProcessor = new CustomerBeanPostProcessor();
        beanFactory.addBeanPostProcessor(customerBeanPostProcessor);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        assertEquals(car.getBrand(), "lamborghini");
    }
}
