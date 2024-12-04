package org.example.spring.aop;

import java.lang.reflect.Method;

/**
 * @Author Roc
 * @Date 2024/12/4 16:33
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
