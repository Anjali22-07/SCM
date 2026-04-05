package com.scm.smartcontactmanager.Services;

import java.util.List;
import java.util.Optional;

import com.scm.smartcontactmanager.entities.User;

public interface UserService {
  
     User saveUser(User user);
     Optional<User> findUserById(String Id); 
     Optional<User> updateUser(User user);
     void deleteUser(String Id);
     Boolean isUserExist(String Id);
     Boolean isUserExistByEmail(String email);
     List<User> getAllUsers();

}
