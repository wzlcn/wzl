package com.wzl.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @PostMapping("user/login")
    public String login(String username,String password){
        return "dashboard";
    }
}
