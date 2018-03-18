package com.sws.hrmapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    @RequestMapping(value = "/")
    public String hello(){
        return "/loginForm";
    }
}
