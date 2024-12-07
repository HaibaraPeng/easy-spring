package org.example.spring.aop;

import lombok.Getter;
import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @Author Roc
 * @Date 2024/12/5 16:07
 */
@Getter
@Setter
public class AdvisedSupport {

    //是否使用cglib代理
    private boolean proxyTargetClass = false;

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;
}
