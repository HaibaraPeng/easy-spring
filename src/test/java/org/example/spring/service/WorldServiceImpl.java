package org.example.spring.service;

import lombok.Setter;

/**
 * @Author Roc
 * @Date 2024/12/5 14:18
 */
public class WorldServiceImpl implements WorldService {

    @Setter
    private String name;

    @Override
    public void explode() {
        System.out.println("The Earth is going to explode");
    }

    @Override
    public String getName() {
        return name;
    }
}
