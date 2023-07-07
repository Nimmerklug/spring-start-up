package org.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //allow to serve rest endpoints
public class HomeController {

    @Value("${my.welcome.message}")
    //@PropertySource
    private String welcomeMessage;

    @GetMapping("/")
    public String welcomeWordString() {
        return welcomeMessage;
    }

    @GetMapping("/hi")
    public String helloWordString() {
        return "!!! Hello World !!!";
    }

    @GetMapping("/list")
    public List<String> helloWordList() {
        return List.of("Hello", "World");
    }

}
