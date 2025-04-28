package com.learning.demo;

import org.springframework.stereotype.Component;

@Component
public class Desktop  implements Computer{
    public void compile(){
        System.out.println("Compile Desktop");
    }
}
