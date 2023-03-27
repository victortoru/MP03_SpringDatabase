package com.example.MP03_SpringDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.UnresolvedAddressException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO repository;


    public List<User> findAll() { return repository.findAll();}
}
