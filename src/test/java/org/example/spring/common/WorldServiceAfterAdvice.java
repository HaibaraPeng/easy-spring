package org.example.spring.common;

import org.example.spring.aop.AfterAdvice;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 15:51
 */
public class WorldServiceAfterAdvice implements AfterAdvice {

    @Override
    public void after(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterAdvice: do something after the earth explodes");
    }
}
