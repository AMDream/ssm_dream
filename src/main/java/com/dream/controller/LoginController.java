package com.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/inter")
    public String Interceptor(){
        System.out.println("Interceptor");
        return "index";
    }
}
