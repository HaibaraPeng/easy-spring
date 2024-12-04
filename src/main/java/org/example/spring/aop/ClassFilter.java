package org.example.spring.aop;

/**
 * @Author Roc
 * @Date 2024/12/4 16:32
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
