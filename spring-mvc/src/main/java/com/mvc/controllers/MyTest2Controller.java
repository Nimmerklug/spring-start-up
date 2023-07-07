package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTest2Controller {

    @GetMapping("/exit")
    public String byePage() {
        return "test2/exit";
    }
}
