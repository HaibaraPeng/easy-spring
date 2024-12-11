package org.example.spring.aop;

/**
 * @Author Roc
 * @Date 2024/12/11 16:40
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
