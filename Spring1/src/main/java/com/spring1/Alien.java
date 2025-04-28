package com.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int age;

    @Autowired
    @Qualifier("laptop")
    private Computer com;

    Alien(){
        System.out.println("Alien Object Created");
    }

    Alien(int age){
        System.out.println("Para Alien Object Created");
        this.age = age;
    }

    public void code(){
        System.out.println("Coding...");
        com.display();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }
}
