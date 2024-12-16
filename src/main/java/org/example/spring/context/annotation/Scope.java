package org.example.spring.context.annotation;

import java.lang.annotation.*;

/**
 * @Author Roc
 * @Date 2024/12/16 14:32
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
