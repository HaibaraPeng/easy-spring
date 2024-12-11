package org.example.spring.aop;

import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author Roc
 * @Date 2024/12/11 15:25
 */
@Setter
public class GenericInterceptor implements MethodInterceptor {

    private BeforeAdvice beforeAdvice;
    private AfterAdvice afterAdvice;
    private AfterReturningAdvice afterReturningAdvice;
    private ThrowsAdvice throwsAdvice;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = null;
        try {
            // 前置通知
            if (beforeAdvice != null) {
                beforeAdvice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
            }
            result = methodInvocation.proceed();
        } catch (Exception throwable) {
            // 异常通知
            if (throwsAdvice != null) {
                throwsAdvice.throwsHandle(throwable, methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
            }
        } finally {
            // 后置通知
            if (afterAdvice != null) {
                afterAdvice.after(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
            }
        }
        // 返回通知
        if (afterReturningAdvice != null) {
            afterReturningAdvice.afterReturning(result, methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        }
        return result;
    }
}
