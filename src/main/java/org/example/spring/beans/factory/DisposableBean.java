package org.example.spring.beans.factory;

/**
 * @Author Roc
 * @Date 2024/11/25 16:29
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
