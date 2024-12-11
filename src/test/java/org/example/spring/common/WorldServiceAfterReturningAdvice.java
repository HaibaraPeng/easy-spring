package org.example.spring.common;

import org.example.spring.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 15:52
 */
public class WorldServiceAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvice: do something after the earth explodes return");
    }
}
