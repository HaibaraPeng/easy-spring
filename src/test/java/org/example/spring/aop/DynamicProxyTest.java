package org.example.spring.aop;

import org.example.spring.aop.aspectj.AspectJExpressionPointcut;
import org.example.spring.aop.framework.JdkDynamicAopProxy;
import org.example.spring.common.WorldServiceInterceptor;
import org.example.spring.service.WorldService;
import org.example.spring.service.WorldServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @Author Roc
 * @Date 2024/12/5 14:15
 */
public class DynamicProxyTest {

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService worldService = new WorldServiceImpl();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.example.spring.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);

        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }
}
