package org.example.spring.bean;

import org.example.spring.beans.factory.DisposableBean;
import org.example.spring.beans.factory.InitializingBean;
import org.example.spring.bean.Car;
import org.example.spring.beans.factory.annotation.Autowired;
import org.example.spring.stereotype.Component;

/**
 * @Author Roc
 * @Date 2024/11/21 13:54
 */
@Component
public class Person implements InitializingBean, DisposableBean {

    private String name;

    private int age;

    @Autowired
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void customInitMethod() {
        System.out.println("I was born in the method named customInitMethod");
    }

    public void customDestroyMethod() {
        System.out.println("I died in the method named customDestroyMethod");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("I died in the method named destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I was born in the method named afterPropertiesSet");
    }
}
