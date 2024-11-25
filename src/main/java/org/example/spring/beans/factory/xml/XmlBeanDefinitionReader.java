package org.example.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.example.spring.beans.PropertyValue;
import org.example.spring.beans.exception.BeansException;
import org.example.spring.beans.factory.config.BeanDefinition;
import org.example.spring.beans.factory.config.BeanReference;
import org.example.spring.beans.factory.support.AbstractBeanDefinitionReader;
import org.example.spring.beans.factory.support.BeanDefinitionRegistry;
import org.example.spring.core.io.Resource;
import org.example.spring.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Roc
 * @Date 2024/11/22 15:57
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String INIT_METHOD_ATTRIBUTE = "init-method";
    public static final String DESTROY_METHOD_ATTRIBUTE = "destroy-method";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
            try {
                doLoadBeanDefinitions(inputStream);
            } finally {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    private void doLoadBeanDefinitions(InputStream inputStream) {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                if (BEAN_ELEMENT.equals(childNodes.item(i).getNodeName())) {
                    // 解析bean标签
                    Element beanElement = (Element) childNodes.item(i);
                    String id = beanElement.getAttribute(ID_ATTRIBUTE);
                    String name = beanElement.getAttribute(NAME_ATTRIBUTE);
                    String className = beanElement.getAttribute(CLASS_ATTRIBUTE);
                    String initMethodName = beanElement.getAttribute(INIT_METHOD_ATTRIBUTE);
                    String destroyMethodName = beanElement.getAttribute(DESTROY_METHOD_ATTRIBUTE);

                    Class<?> clazz;
                    try {
                        clazz = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new BeansException("Cannot find class [" + className + "]");
                    }

                    String beanName = StrUtil.isNotBlank(id) ? id : StrUtil.isNotBlank(name) ? name : StrUtil.lowerFirst(clazz.getSimpleName());
                    if (getRegistry().containsBeanDefinition(beanName)) {
                        throw new BeansException("Duplicate bean name [" + beanName + "] is not allowed");
                    }

                    BeanDefinition beanDefinition = new BeanDefinition(clazz);
                    beanDefinition.setInitMethodName(initMethodName);
                    beanDefinition.setDestroyMethodName(destroyMethodName);

                    for (int j = 0; j < beanElement.getChildNodes().getLength(); j++) {
                        if (beanElement.getChildNodes().item(j) instanceof Element) {
                            // 解析property标签
                            Element propertyElement = (Element) beanElement.getChildNodes().item(j);
                            String propertyName = propertyElement.getAttribute(NAME_ATTRIBUTE);
                            String propertyValue = propertyElement.getAttribute(VALUE_ATTRIBUTE);
                            String propertyRef = propertyElement.getAttribute(REF_ATTRIBUTE);

                            if (StrUtil.isBlank(propertyName)) {
                                throw new BeansException("The property name must not be null");
                            }

                            Object value = StrUtil.isNotBlank(propertyRef) ? new BeanReference(propertyRef) : propertyValue;
                            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, value));
                        }
                    }

                    getRegistry().registerBeanDefinition(beanName, beanDefinition);
                }
            }
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        loadBeanDefinitions(resourceLoader.getResource(location));
    }


}
