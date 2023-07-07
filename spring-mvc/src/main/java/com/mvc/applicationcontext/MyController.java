package com.mvc.applicationcontext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller = Component + add.functional
// View (presentation) ⇆ Controller (HTTP request) ⇆ Model (interaction with DB) ⇆ DB
public class MyController {
    @GetMapping("/hello-world")
    public String sayHelloWorld() {
        return "hello_world";// return view hello_world.html
    }
}
