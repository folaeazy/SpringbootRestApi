package com.codewithflash.restapi.controllers;

import com.codewithflash.restapi.services.LoggedUserManagementService;
import com.codewithflash.restapi.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private  final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public HomeController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }
    @GetMapping("/main")
    public String index(
            @RequestParam (required = false) String logout,
            Model model
    ){
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();
        if (username == null) {
            return  "redirect:/";
        }
        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
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
