package com.scm.smartcontactmanager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("Home Page Handleerr");
     return "home";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("about Page Handleerr");
     return "about";
    }
    
     @RequestMapping("/services")
    public String services(){
        System.out.println("Service Page Handleerr");
     return "services";
    }
    
    @RequestMapping("/contact")
    public String contact(){
        System.out.println("contact Page Handleerr");
     return "contact";
    }

     @GetMapping("/login")
     public String login() {
         return new String("login");
     }
     
     @GetMapping("/register")
     public String register() {
         return new String("register");
     }
     

}
