package com.scm.smartcontactmanager.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor    //since we are using Lombok we can create our getters and setters as well as constructors using annotations
@NoArgsConstructor
public class User implements UserDetails{

    @Id
    private String userId;
    private String name;
    private String email;
    private String password;
    private String about;
    @Column(columnDefinition = "TEXT")
    private String profilePic;
    private String phoneNumber;

    //for verification
     private boolean enabled=true;
     private boolean emailVerified= false;
     private boolean phoneVerified= false;

     //User logging -- SELF, GOOGlE, GITHUB
      @Enumerated(value= EnumType.STRING)    //to save it as a String In DB
      //SELF , GOOGLE, GIT, FACEBOOK, TWITTER
      private Providers providers= Providers.SELF;
      private String providersUserId;

      @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
      private List<Contacts> contacts= new ArrayList<>();

      List<String> roleList= new ArrayList<>();
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles= roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
      return roles;    
    }

      @Override
      public String getUsername() {
        // TODO Auto-generated method stub
        return this.email;
      }

      @Override
       public String getPassword(){
        return this.password;
       }
      
      

}
