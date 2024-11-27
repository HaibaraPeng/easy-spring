package org.example.spring.context;

import java.util.EventObject;

/**
 * @Author Roc
 * @Date 2024/11/27 16:37
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
