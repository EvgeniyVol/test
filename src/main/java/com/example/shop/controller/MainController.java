package com.example.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }
}
