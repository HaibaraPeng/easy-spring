package org.example.spring.beans.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Roc
 * @Date 2024/11/20 10:39
 */
public class BeanFactory {

    private final Map<String, Object> beanMap = new ConcurrentHashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
