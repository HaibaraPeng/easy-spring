package org.example.spring.beans;

import lombok.Getter;

/**
 * @Author Roc
 * @Date 2024/11/21 11:29
 */
@Getter
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
