package com.codewithflash.restapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/home")// request parameters
    public String home( @RequestParam(required = false) String color,
                        @RequestParam(required = false) String name,
                        Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }

    @RequestMapping("/home/{color}") //path variable
    public String home( @PathVariable String color,  Model page) {
        page.addAttribute("username", "raymond");
        page.addAttribute("color" , color);
        return "home.html";
    }


}
