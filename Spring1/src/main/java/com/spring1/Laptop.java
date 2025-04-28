package com.spring1;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    @Override
    public void display() {
        System.out.println("Laptop Display");
    }
}
