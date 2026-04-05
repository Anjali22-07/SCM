package com.scm.smartcontactmanager.Services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.smartcontactmanager.Helper.ResourceNotFoundException;
import com.scm.smartcontactmanager.Services.UserService;
import com.scm.smartcontactmanager.entities.User;
import com.scm.smartcontactmanager.repositories.UserRepository;

@Service
public class UserImplementation implements UserService {

    @Autowired
    private UserRepository userRepo;  //parametrised constructor is advised instead of Autowired
    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
      //  UserId: we have to generate
        String userId= UUID.randomUUID().toString(); // A class that represents an immutable universally unique identifier (UUID). A UUID represents a 128-bit value.
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findUserById(String Id) {
       
        return userRepo.findById(Id);
   
    }

    @Override
    public Optional<User> updateUser(User user) {
        
        //first we need to  fetch the user by the user Id 
        User user1= userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
    
          user1.setName(user.getName());
          user1.setEmail(user.getEmail());
          user1.setPassword(user.getPassword());
          user1.setContacts(user.getContacts());
          user1.setAbout(user.getAbout());
          user1.setProfilePic(user.getProfilePic());
          user1.setPhoneVerified(user.isPhoneVerified());
          user1.setEnabled(user.isEnabled());
          user1.setEmailVerified(user.isEmailVerified());
          user1.setProviders(user.getProviders());

          //save the user 
          User save= userRepo.save(user1);

          return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String Id) {
        //fetch the user using id
         User user1= userRepo.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
            userRepo.delete(user1);
        }

    @Override
    public Boolean isUserExist(String Id) {
       User user1= userRepo.findById(Id).orElse(null);
       return user1!=null ? true :false;
         
    }

    @Override
    public Boolean isUserExistByEmail(String email) {
       User user1= userRepo.findByEmail(email).orElse(null);
       return user1!=null ?true : false;
    }

    @Override
    public List<User> getAllUsers() {
       return userRepo.findAll();   //Returns all instances of the type.
    }

}
