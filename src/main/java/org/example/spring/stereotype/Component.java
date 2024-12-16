package org.example.spring.stereotype;

import java.lang.annotation.*;

/**
 * @Author Roc
 * @Date 2024/12/13 18:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
