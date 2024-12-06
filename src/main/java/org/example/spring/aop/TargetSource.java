package org.example.spring.aop;

import lombok.Getter;

/**
 * @Author Roc
 * @Date 2024/12/5 16:09
 */
public class TargetSource {

    @Getter
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

}
