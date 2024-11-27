package org.example.spring.beans.factory.common;

import org.example.spring.beans.factory.FactoryBean;
import org.example.spring.beans.factory.bean.Car;

/**
 * @Author Roc
 * @Date 2024/11/27 15:37
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
