package org.example.spring.beans.factory;

import org.example.spring.beans.exception.BeanException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Roc
 * @Date 2024/11/20 10:39
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;
}
