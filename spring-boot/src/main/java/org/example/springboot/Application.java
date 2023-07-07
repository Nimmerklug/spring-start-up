package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //run server and connect db
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}

