package com.scm.smartcontactmanager.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    //create user and login usng java code within memory source

    //spring security uses user detail service to login.uses user detail service to fetch user. the detail service has a method called as loadUserByUserName and this method. then the loaded user and the user signing in are verified and if the password matches then it enables logging in
    //we have different type of services available-- one of them is inMemoryUserDetailService 

    @Bean
    public UserDetailsService userDetailsService(){
          UserDetails user1= User. withDefaultPasswordEncoder().username("admin123").password("admin123").build();
          var inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1);
         return  inMemoryUserDetailsManager;
    }
} 
