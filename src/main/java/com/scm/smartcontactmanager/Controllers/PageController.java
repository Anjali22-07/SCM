package com.scm.smartcontactmanager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.smartcontactmanager.Forms.UserForm;



import org.springframework.web.bind.annotation.RequestMethod;



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
     public String register(Model model) {
        UserForm userform= new UserForm();
       
         model.addAttribute("userForm", userform);
         return new String("register");
     }

     
     @RequestMapping(value="/signingUp" , method=RequestMethod.POST)
     public String processRegistration(@ModelAttribute UserForm userForm){
       //fetch data from the form
       System.out.println(userForm);
       //validate the form 
       //save to DB
       //redirect to login page

        return "redirect:/login";
     }
     

}
