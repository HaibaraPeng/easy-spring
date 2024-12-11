package org.example.spring.aop;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 16:45
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
