package org.example.spring.beans.factory.annotation;

import java.lang.annotation.*; /**
 * @Author Roc
 * @Date 2024/12/17 15:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}
