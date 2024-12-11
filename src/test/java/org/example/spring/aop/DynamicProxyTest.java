package org.example.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.annotation.Before;
import org.example.spring.aop.aspectj.AspectJExpressionPointcut;
import org.example.spring.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.example.spring.aop.framework.CglibAopProxy;
import org.example.spring.aop.framework.JdkDynamicAopProxy;
import org.example.spring.aop.framework.ProxyFactory;
import org.example.spring.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.example.spring.common.*;
import org.example.spring.service.WorldService;
import org.example.spring.service.WorldServiceImpl;
import org.example.spring.service.WorldServiceWithExceptionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/12/5 14:15
 */
public class DynamicProxyTest {

    private AdvisedSupport advisedSupport;

    @BeforeEach
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.example.spring.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testProxyFactory() throws Exception {
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testBeforeAdvice() throws Exception {
        //设置BeforeAdvice
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterAdvice() throws Exception {
        //设置AfterAdvice
        WorldServiceAfterAdvice afterAdvice = new WorldServiceAfterAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setAfterAdvice(afterAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterReturningAdvice() throws Exception {
        //设置AfterReturningAdvice
        WorldServiceAfterReturningAdvice afterReturningAdvice = new WorldServiceAfterReturningAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setAfterReturningAdvice(afterReturningAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testThrowsAdvice() throws Exception {
        WorldService worldService = new WorldServiceWithExceptionImpl();
        //设置ThrowsAdvice
        WorldServiceThrowsAdvice throwsAdvice = new WorldServiceThrowsAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setThrowsAdvice(throwsAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setTargetSource(new TargetSource(worldService));

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }


    @Test
    public void testAllAdvice() throws Exception {
        //设置before、after、afterReturning
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(new WorldServiceBeforeAdvice());
        methodInterceptor.setAfterAdvice(new WorldServiceAfterAdvice());
        methodInterceptor.setAfterReturningAdvice(new WorldServiceAfterReturningAdvice());
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAllAdviceWithException() throws Exception {
        WorldService worldService = new WorldServiceWithExceptionImpl();
        //设置before、after、throws
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(new WorldServiceBeforeAdvice());
        methodInterceptor.setAfterAdvice(new WorldServiceAfterAdvice());
        methodInterceptor.setThrowsAdvice(new WorldServiceThrowsAdvice());
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setTargetSource(new TargetSource(worldService));

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception {
        WorldService worldService = new WorldServiceImpl();

        //Advisor是Pointcut和Advice的组合
        String expression = "execution(* org.example.spring.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
//			advisedSupport.setProxyTargetClass(true);   //JDK or CGLIB

            WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
            proxy.explode();
        }
    }
}
