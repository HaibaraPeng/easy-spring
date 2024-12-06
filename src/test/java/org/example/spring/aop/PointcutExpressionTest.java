package org.example.spring.aop;

import org.example.spring.aop.aspectj.AspectJExpressionPointcut;
import org.example.spring.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/4 15:35
 */
public class PointcutExpressionTest {

    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.example.spring.beans.factory.service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("sayHello");

        Assertions.assertTrue(pointcut.matches(clazz));
        Assertions.assertTrue(pointcut.matches(method, clazz));
    }
}
