package com.codewithflash.restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "raymond");
        page.addAttribute("color", "red");
        return "home.html";
    }


}
