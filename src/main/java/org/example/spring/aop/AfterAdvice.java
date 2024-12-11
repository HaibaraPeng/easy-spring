package org.example.spring.aop;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 15:25
 */
public interface AfterAdvice extends Advice {

    void after(Method method, Object[] args, Object target) throws Throwable;
}
