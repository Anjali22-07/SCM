package com.scm.smartcontactmanager.Config;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.smartcontactmanager.Helper.appConstants;
import com.scm.smartcontactmanager.entities.Providers;
import com.scm.smartcontactmanager.entities.User;
import com.scm.smartcontactmanager.repositories.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthAuhenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

            //we cannot use this because different data is recieved from different providers 
                // //save data in DB 
                // //DefaultOAuth2User - stores the user information received from the OAuth provider.
                // DefaultOAuth2User user= (DefaultOAuth2User)authentication.getPrincipal();

                //     String email= user.getAttribute("email").toString();
                //     String name= user.getAttribute("name").toString();
                //     String picture= user.getAttribute("picture").toString();

                //     //Create User and then save 

                //     User user1=new User();
                //     user1.setEmail(email);
                //     user1.setName(name);
                //     user1.setProfilePic(picture);
                //     user1.setPassword("password");
                //     user1.setUserId(UUID.randomUUID().toString());
                //     user1.setProviders(Providers.GOOGLE);
                //     user1.setEnabled(true);
                //     user1.setEmailVerified(true);
                //     user1.setProvidersUserId(user.getName());

                //     //to save 
                //      User user2= userRepository.findByEmail(email).orElse(null);
                //      if(user2==null){
                //         userRepository.save(user1);
                //      }

        //so we first identify the provider and  then save data accordingly
        //to identify the provider we use OAuth2AutherizationToken 

       var oauth2AuthenticationToken= (OAuth2AuthenticationToken)authentication;
        String oauthProviderId= oauth2AuthenticationToken.getAuthorizedClientRegistrationId();

        var oAuth2User= (DefaultOAuth2User)authentication.getPrincipal();
        User user= new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setRoleList(List.of(appConstants.ROLE_USER));
        user.setEnabled(true);
        user.setEmailVerified(true);

        //if the provider is google
        if(oauthProviderId.equalsIgnoreCase("google")){
             String email=oAuth2User.getAttribute("email").toString();
            user.setEmail(email);
            user.setName(oAuth2User.getAttribute("name").toString());
            user.setProfilePic(oAuth2User.getAttribute("picture").toString());
            user.setPassword("dummy");
            user.setProvidersUserId(oAuth2User.getName());
            user.setAbout("This user loggen in using google account");

            User user2= userRepository.findByEmail(email).orElse(null);
                     if(user2==null){
                        userRepository.save(user);
                     }



        }else if(oauthProviderId.equalsIgnoreCase("github")){
           //fetch email
            String email= oAuth2User.getAttribute("email")!=null?oAuth2User.getAttribute("email").toString() : oAuth2User.getAttribute("login").toString()+"github.com";
            String name= oAuth2User.getAttribute("login").toString();
            String picture = oAuth2User.getAttribute("avatar_url").toString();
            String providerId= oAuth2User.getName();
            user.setEmail(email);
            user.setName(name);
            user.setProfilePic(picture);
            user.setProvidersUserId(providerId);
            user.setPassword("dummy");
            user.setAbout("The user logged in using Github Account");

            User user2= userRepository.findByEmail(email).orElse(null);
                     if(user2==null){
                        userRepository.save(user);
                     }


        }

        
                    //redirect to the home page
                response.sendRedirect("/users/dashboard");
        }

}
