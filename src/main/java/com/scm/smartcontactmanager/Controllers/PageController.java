package com.scm.smartcontactmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.scm.smartcontactmanager.Forms.UserForm;
import com.scm.smartcontactmanager.Helper.Message;
import com.scm.smartcontactmanager.Helper.MessageType;
import com.scm.smartcontactmanager.Services.UserService;
import com.scm.smartcontactmanager.entities.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class PageController {
 
     @Autowired
    private UserService userService;

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
     public String processRegistration(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
       //fetch data from the form
       System.out.println(userForm);
       //validate the form 
       if(rBindingResult.hasErrors()){
        return "register";
       }
       //save to DB

       //UserForm--> User
       User user= new User();
       user.setName(userForm.getName());
       user.setEmail(userForm.getEmail());
       user.setPassword(userForm.getPassword());
       user.setAbout(userForm.getAbout());
       user.setPhoneNumber(userForm.getPhoneNumber());
       user.setProfilePic("/images/ProfilePcic.jpeg");


        //saving user in db
         User saveUser=userService.saveUser(user);
         System.out.println(saveUser);
       //redirect to login page

       //Displaying message dynamically

       Message message=Message.builder().content("Registerd Successfully").type(MessageType.green).build();

         session.setAttribute("message", message);
        return "redirect:/register";
     }
     

}
