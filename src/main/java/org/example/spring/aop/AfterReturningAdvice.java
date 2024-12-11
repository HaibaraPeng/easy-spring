package org.example.spring.aop;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 15:41
 */
public interface AfterReturningAdvice extends Advice {

    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;
}
