package org.example.spring.ioc;

import org.example.spring.service.HelloService;
import org.example.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/11/26 15:12
 */
public class AwareInterfaceTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        Assertions.assertNotNull(helloService.getApplicationContext());
        Assertions.assertNotNull(helloService.getBeanFactory());
    }
}
