package com.scm.smartcontactmanager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor    //since we are using Lombok we can create our getters and setters as well as constructors using annotations
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    private String name;
    private String email;
    private String password;
    private String about;
    private String profilePic;
    private String phoneNumber;

    //for verification
     private boolean enabled=false;
     private boolean emailVerified= false;
     private boolean phoneVerified= false;

     //User logging -- SELF, GOOGlE, GITHUB

      private Providers providers= Providers.SELF;
      private String providersUserId;

      private List<Contacts> contacts= new ArrayList<>();

      

}
