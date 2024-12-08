package org.example.spring.beans.factory;

import org.example.spring.beans.factory.bean.Car;
import org.example.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/11/27 15:21
 */
public class PrototypeBeanTest {

    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);
        Assertions.assertNotEquals(car1, car2);
    }
}
