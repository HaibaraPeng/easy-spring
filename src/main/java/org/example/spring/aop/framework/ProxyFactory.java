package org.example.spring.aop.framework;

import org.example.spring.aop.AdvisedSupport;

/**
 * @Author Roc
 * @Date 2024/12/6 17:17
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new CglibAopProxy(advisedSupport);
        } else {
            return new JdkDynamicAopProxy(advisedSupport);
        }
    }
}
