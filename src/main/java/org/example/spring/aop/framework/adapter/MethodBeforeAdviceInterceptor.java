package org.example.spring.aop.framework.adapter;

import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.example.spring.aop.MethodBeforeAdvice;

/**
 * @Author Roc
 * @Date 2024/12/11 16:44
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    @Setter
    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 前置通知
        this.advice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
