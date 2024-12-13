package org.example.spring.beans.context;

import org.example.spring.bean.Car;
import org.example.spring.bean.Person;
import org.example.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Roc
 * @Date 2024/11/25 15:01
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        //name属性在CustomBeanFactoryPostProcessor中被修改为roc
        assertEquals(person.getName(), "roc");

        Car car = applicationContext.getBean("car", Car.class);
        System.out.println(car);
        //brand属性在CustomerBeanPostProcessor中被修改为lamborghini
        assertEquals(car.getBrand(), "lamborghini");
    }
}
