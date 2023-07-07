package com.mvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class MyTest1Controller {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest servletRequest) {
        String name = servletRequest.getParameter("name");
        String surname = servletRequest.getParameter("surname");

        System.out.printf("%nHello from : %s %s%n", name, surname);

        return "test1/hello";
    }

    @GetMapping("/bye")
    public String byePage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model) {

        System.out.printf("%nGoodBye from : %s %s%n", name, surname);
        //key:value; with model we will return value by thymeleaf <p th:text="${message}"></p>
        model.addAttribute("message", "GoodBye, " + name + " " + surname);

        return "test1/bye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model) {
        double result;

        switch (action.toLowerCase()) {
            case "multiplication" -> result = a * b;
            case "addition" -> result = a + b;
            case "substation" -> result = a - b;
            case "division" -> result = a / (double) b;
            default -> {
                System.err.println("Unexpected action value: " + action);
                result = -0;
            }

        }

        model.addAttribute("result", result);

        return "test1/calculator";
    }
}
