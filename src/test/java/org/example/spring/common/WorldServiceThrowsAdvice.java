package org.example.spring.common;

import org.example.spring.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 15:53
 */
public class WorldServiceThrowsAdvice implements ThrowsAdvice {
    @Override
    public void throwsHandle(Throwable throwable, Method method, Object[] args, Object target) {
        System.out.println("ThrowsAdvice: do something when the earth explodes function throw an exception");
    }
}
