package com.learning.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
    public void compile(){
        System.out.println("Compile Laptop");
    }
}
