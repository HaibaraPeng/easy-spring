package org.example.spring.context;

import org.example.spring.beans.factory.HierarchicalBeanFactory;
import org.example.spring.beans.factory.ListableBeanFactory;
import org.example.spring.core.io.ResourceLoader;

/**
 * @Author Roc
 * @Date 2024/11/23 15:47
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
