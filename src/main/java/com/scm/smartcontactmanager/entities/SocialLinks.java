package com.scm.smartcontactmanager.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SocialLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int Id;
     private String links;
     private String title;
     @ManyToOne
     private Contacts contact;
}
