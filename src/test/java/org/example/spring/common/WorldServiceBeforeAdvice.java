package org.example.spring.common;


import org.example.spring.aop.BeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class WorldServiceBeforeAdvice implements BeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice: do something before the earth explodes");
    }
}
