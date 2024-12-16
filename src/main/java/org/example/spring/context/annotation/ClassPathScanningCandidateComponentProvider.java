package org.example.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import org.example.spring.beans.factory.config.BeanDefinition;
import org.example.spring.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author Roc
 * @Date 2024/12/13 18:03
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        // 扫描Component注解的类
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
