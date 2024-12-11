package org.example.spring.aop;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/11 15:41
 */
public interface ThrowsAdvice extends Advice {
    void throwsHandle(Throwable throwable, Method method, Object[] args, Object target);
}
