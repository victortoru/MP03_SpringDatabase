package com.example.MP03_SpringDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/users";
    @Autowired
    UserController userController;

    @GetMapping
    public List<UserDto> readAll(){
        return userController.getAllUsers();
    }
}
