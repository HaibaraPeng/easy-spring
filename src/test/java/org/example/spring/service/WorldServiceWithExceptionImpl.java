package org.example.spring.service;

/**
 * @Author Roc
 * @Date 2024/12/11 15:53
 */
public class WorldServiceWithExceptionImpl implements WorldService {
    @Override
    public void explode() {
        System.out.println("The Earth is going to explode with an Exception");
        throw new RuntimeException();
    }
}
