package org.example.spring.beans.context.event;

import org.example.spring.context.ApplicationListener;

/**
 * @Author Roc
 * @Date 2024/11/28 17:08
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
