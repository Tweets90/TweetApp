package com.tweet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tweet.entites.User;
import com.tweet.payloads.UserDto;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    
    public UserDto findByEmail(String email);
    

}
