package org.example.spring.aop;

/**
 * @Author Roc
 * @Date 2024/12/4 16:25
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
