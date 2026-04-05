package com.scm.smartcontactmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entities.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    //extra methods dp relatedOperations
    //custom query methods
    //custom finder methods

    Optional<User> findByEmail(String email);
    
}
