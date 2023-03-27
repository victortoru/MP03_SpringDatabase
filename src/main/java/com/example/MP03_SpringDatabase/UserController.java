package com.example.MP03_SpringDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public List<UserDto> getAllUsers(){
        List<User> users = userService.findAll();
        List<UserDto> userDtos = users.stream().map(user -> new UserDto(user)).toList();
        return userDtos;
    }
}
