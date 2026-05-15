package com.scm.smartcontactmanager.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.smartcontactmanager.Services.Implementation.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfig {

    //create user and login usng java code within memory service

    //spring security uses user detail service to login.uses user detail service to fetch user. the detail service has a method called as loadUserByUserName and this method. then the loaded user and the user signing in are verified and if the password matches then it enables logging in
    //we have different type of services available-- one of them is inMemoryUserDetailService 

    // @Bean
    // public UserDetailsService userDetailsService(){
    //       UserDetails user1= User. withDefaultPasswordEncoder().username("admin123").password("admin123").build();
    //       var inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1);
    //      return  inMemoryUserDetailsManager;
    // }

    //Confiuring Users from DataBase
    @Autowired
    private SecurityCustomUserDetailsService securityCustomUserDetailsService;

    @Autowired
    private OAuthAuhenticationSuccessHandler oAuthAuhenticationSuccessHandler;

    @Bean
    public AuthenticationProvider authenticationProvider(){


        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider(userDetailsService());

       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return  securityCustomUserDetailsService;
    }

    //since we only need to protect the user's pages we will add filters

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        
        httpSecurity.authorizeHttpRequests(authorize->{
               authorize.requestMatchers("/users/**").authenticated();
               authorize.anyRequest().permitAll();
        });


        httpSecurity.formLogin(FormLogin->{
                FormLogin.loginPage("/login");
                FormLogin.loginProcessingUrl("/authenticate");
                FormLogin.defaultSuccessUrl("/users/dashboard");
                FormLogin.usernameParameter("email");
                FormLogin.passwordParameter("password");
        });

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.logout(formLogOut->{
            formLogOut.logoutUrl("/do-logout");
            formLogOut.logoutSuccessUrl("/login?logout=true");
        });

         httpSecurity.oauth2Login(OAuth->{
            OAuth.loginPage("/login");
            OAuth.successHandler(oAuthAuhenticationSuccessHandler);
            OAuth.defaultSuccessUrl("/users/profile");
         });
        return httpSecurity.build();
    }

    
} 
