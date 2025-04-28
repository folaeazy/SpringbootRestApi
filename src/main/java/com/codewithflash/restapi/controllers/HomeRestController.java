package com.codewithflash.restapi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("/hellorest")
    @ResponseBody
    public  String helloRest() {
        return "Hello Rest Api";
    }
}
