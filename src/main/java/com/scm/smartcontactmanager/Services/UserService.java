package com.scm.smartcontactmanager.Services;

import java.util.List;
import java.util.Optional;

import com.scm.smartcontactmanager.entities.User;

public interface UserService {
  
     User saveUser(User user);
     Optional<User> findUserById(String Id); 
     User updateUser(User user);
     void deleteUser(User user);
     Boolean isUserExist(String Id);
     Boolean isUserExistByEmail(String email);
     List<User> getAllUsers();

}
