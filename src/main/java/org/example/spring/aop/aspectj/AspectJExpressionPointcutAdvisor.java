package org.example.spring.aop.aspectj;

import lombok.Setter;
import org.aopalliance.aop.Advice;
import org.example.spring.aop.Pointcut;
import org.example.spring.aop.PointcutAdvisor;

/**
 * @Author Roc
 * @Date 2024/12/11 16:41
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;
    @Setter
    private Advice advice;
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
        pointcut = new AspectJExpressionPointcut(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}
