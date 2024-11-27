package org.example.spring.beans.factory;

import org.example.spring.beans.factory.bean.Car;
import org.example.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/11/27 16:20
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Car car = applicationContext.getBean("car", Car.class);
        Assertions.assertEquals(car.getBrand(), "porsche");
    }
}
