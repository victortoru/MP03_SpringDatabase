package com.example.MP03_SpringDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    UserService userService;

    public List<UserDto> getAllUsers(){
        List<User> users = userService.findAll();
        List<UserDto> userDtos = users.stream().map(UserDto::new).toList();
        return userDtos;
    }
}
