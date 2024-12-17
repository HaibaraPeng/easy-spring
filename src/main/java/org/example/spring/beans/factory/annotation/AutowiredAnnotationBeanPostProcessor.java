package org.example.spring.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import org.example.spring.beans.PropertyValue;
import org.example.spring.beans.PropertyValues;
import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.BeanFactory;
import org.example.spring.beans.factory.BeanFactoryAware;
import org.example.spring.beans.factory.ConfigurableListableBeanFactory;
import org.example.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.lang.reflect.Field;

/**
 * @Author Roc
 * @Date 2024/12/16 16:42
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 处理@Value注解
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                String value = annotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                pvs.addPropertyValue(new PropertyValue(field.getName(), value));
            }
        }

        // 处理@Autowired注解
        for (Field field : fields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (autowiredAnnotation != null) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (qualifierAnnotation != null) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }
}
