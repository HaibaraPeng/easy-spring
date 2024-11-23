package org.example.spring.beans.exception;

/**
 * @Author Roc
 * @Date 2024/11/20 11:25
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
