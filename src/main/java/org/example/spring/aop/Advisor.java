package org.example.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author Roc
 * @Date 2024/12/11 16:37
 */
public interface Advisor {

    Advice getAdvice();
}
