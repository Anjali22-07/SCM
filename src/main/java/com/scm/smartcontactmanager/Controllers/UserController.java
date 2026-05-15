package com.scm.smartcontactmanager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    //user DashBoard Page 
    @RequestMapping(value="/users/dashboard", method=RequestMethod.GET)
       public String UserDashBoard(){

         return "users/dashboard";
     }

     @RequestMapping(value="/users/profile", method=RequestMethod.GET)   
     public String UserProfile(){

        return "users/profile";
     }

}
