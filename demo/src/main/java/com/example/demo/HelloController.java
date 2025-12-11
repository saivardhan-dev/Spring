package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/arthoper")
    public Map<String, Object> sumJson(@RequestParam double a, @RequestParam double b){
        Map<String, Object> response = new LinkedHashMap<>();

        double sum = a + b;
        double sub = a - b;
        double mul = a * b;

        response.put("a", a);
        response.put("b", b);
        response.put("sum", sum);
        response.put("sub", sub);
        response.put("mul", mul);

        try {
            double div = a / b;
            response.put("div", div);
        } catch (ArithmeticException e) {
            response.put("div", "Error: Cannot divide by zero");
        }
        return response;
    }
}