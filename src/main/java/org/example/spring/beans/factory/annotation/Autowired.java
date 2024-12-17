package org.example.spring.beans.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Roc
 * @Date 2024/12/17 15:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
public @interface Autowired {
}
