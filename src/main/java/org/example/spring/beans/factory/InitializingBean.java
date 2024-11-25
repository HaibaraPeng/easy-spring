package org.example.spring.beans.factory;

/**
 * @Author Roc
 * @Date 2024/11/25 16:28
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
