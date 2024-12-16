package org.example.spring.bean;

import org.example.spring.stereotype.Component;

/**
 * @Author Roc
 * @Date 2024/11/21 13:54
 */
@Component
public class Car {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
