package org.example.spring.beans.factory.config;

import lombok.Getter;
import lombok.Setter;
import org.example.spring.beans.PropertyValues;

/**
 * @Author Roc
 * @Date 2024/11/20 11:04
 */
public class BeanDefinition {

    public static String SCOPE_SINGLETON = "singleton";

    public static String SCOPE_PROTOTYPE = "prototype";

    @Getter
    @Setter
    private Class beanClass;

    @Getter
    @Setter
    private PropertyValues propertyValues;

    @Getter
    @Setter
    private String initMethodName;

    @Getter
    @Setter
    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;

    @Getter
    private boolean singleton = true;

    @Getter
    private boolean prototype = false;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

}
