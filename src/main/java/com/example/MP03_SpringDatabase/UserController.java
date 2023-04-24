package com.example.MP03_SpringDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        User newUser = new User(userDto);
        User savedUser = userService.save(newUser);
        UserDto savedUserDto = new UserDto(savedUser);
        return ResponseEntity.ok(savedUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    public UserDto updateUser(Integer id, UserDto userDto) {
        User user = userService.findById(id);
        if (user == null) {
            return null;
        }
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        userService.save(user);
        return new UserDto(user);
    }

}
