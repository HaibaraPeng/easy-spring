package org.example.spring.beans.exception;

/**
 * @Author Roc
 * @Date 2024/11/20 11:25
 */
public class BeanException extends RuntimeException {

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
