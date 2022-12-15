package com.tweet.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.tweet.payloads.*;
import com.tweet.entites.User;
import com.tweet.repositories.UserRepo;
import com.tweet.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Override
    public UserDto createUser(UserDto userDto) {
        // TODO Auto-generated method stub
        User user=this.dtoToUser(userDto);
      User savedUser= this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updatuUser(UserDto userDto, Integer userId) {
        // TODO Auto-generated method stub
     //  User user= this.userRepo.findById(userId);
        //orElseThrow(e-> new ConfigDataResourceNotFoundException("User","Id ","userId"));
        
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserDto> getallUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        // TODO Auto-generated method stub

    }
    
    public static void name() {
        
    } User dtoToUser(UserDto userDto)
    {
        User user=new User();
        user.setId(userDto.getId());
        user.setfirstName(userDto.getfirstName());
        user.setlastName(userDto.getlastName());
        user.setuserName(userDto.getuserName());
        user.setemail(userDto.getemail());
        user.setpassword(userDto.getpassword());
        user.setconpassword(userDto.getconpassword());
        user.setcontactNum(userDto.getcontactNum());
        return user;
    }
    
    public UserDto userToDto(User user)
    {
        UserDto userDto=new UserDto();
        userDto.setId(userDto.getId());
        userDto.setfirstName(userDto.getfirstName());
        userDto.setlastName(userDto.getlastName());
        userDto.setemail(userDto.getemail());
        userDto.setuserName(userDto.getuserName());
        userDto.setpassword(userDto.getpassword());
        userDto.setconpassword(userDto.getconpassword());
        userDto.setcontactNum(userDto.getcontactNum());
        return userDto;
    }

}
