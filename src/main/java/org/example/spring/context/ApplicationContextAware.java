package org.example.spring.context;

import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.Aware;

/**
 * @Author Roc
 * @Date 2024/11/26 14:34
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
