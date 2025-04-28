package com.spring1;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    public void display() {
        System.out.println("Coding using Desktop...");
    }
}
