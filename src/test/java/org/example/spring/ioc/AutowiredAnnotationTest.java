package org.example.spring.ioc;

import org.example.spring.bean.Person;
import org.example.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/12/17 15:24
 */
public class AutowiredAnnotationTest {

    @Test
    public void testAutowiredAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");

        Person person = applicationContext.getBean(Person.class);
        Assertions.assertNotNull(person.getCar());
    }
}
