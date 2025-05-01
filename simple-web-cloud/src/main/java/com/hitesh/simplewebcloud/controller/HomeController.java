package com.hitesh.simplewebcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World Home Page";
    }

    @GetMapping("about")
    public String aboutMachine() {
        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String arch = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");
        String user = System.getProperty("user.name");

        return "System info : " + os + " " + version + " " + arch + " " + javaVersion + " " + user;
    }
}
