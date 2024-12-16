package org.example.spring.beans.factory;

import lombok.Setter;
import org.example.spring.beans.PropertyValue;
import org.example.spring.beans.PropertyValues;
import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.config.BeanDefinition;
import org.example.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.example.spring.core.io.DefaultResourceLoader;
import org.example.spring.core.io.Resource;
import org.example.spring.util.StringValueResolver;

import java.util.Properties;

/**
 * @Author Roc
 * @Date 2024/12/13 16:30
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String PLACEHOLDER_PREFIX = "${";
    public static final String PLACEHOLDER_SUFFIX = "}";

    @Setter
    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Properties properties = loadProperties();
        processProperties(beanFactory, properties);

        StringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
        beanFactory.addEmbeddedValueResolver(valueResolver);
    }

    /**
     * 加载属性文件
     *
     * @return
     */
    private Properties loadProperties() {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            return properties;
        } catch (Exception e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    /**
     * 属性值替换占位符
     *
     * @param beanFactory
     * @param properties
     * @throws BeansException
     */
    private void processProperties(ConfigurableListableBeanFactory beanFactory, Properties properties) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            resolvePropertyValue(beanDefinition, properties);
        }
    }

    private void resolvePropertyValue(BeanDefinition beanDefinition, Properties properties) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof String) {
                value = resolvePlaceholder((String) value, properties);
                propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
            }
        }
    }

    private String resolvePlaceholder(String value, Properties properties) {
        // TODO 仅简单支持一个占位符的格式
        String strVal = value;
        StringBuffer buf = new StringBuffer(strVal);
        int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
        int endIndex = strVal.indexOf(PLACEHOLDER_SUFFIX);
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            String propKey = strVal.substring(startIndex + 2, endIndex);
            String propVal = properties.getProperty(propKey);
            buf.replace(startIndex, endIndex + 1, propVal);

        }
        return buf.toString();
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {

        private final Properties properties;

        public PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
