package org.example.spring.ioc;

import org.example.spring.bean.Car;
import org.example.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/12/16 17:23
 */
public class ValueAnnotationTest {

    @Test
    public void testValueAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");

        Car car = applicationContext.getBean("car", Car.class);
        Assertions.assertEquals("lamborghini", car.getBrand());
    }
}
