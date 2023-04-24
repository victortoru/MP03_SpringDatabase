package com.example.MP03_SpringDatabase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.UnresolvedAddressException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO repository;


    public List<User> findAll() { return repository.findAll();}

    public User save(User user) { return repository.save(user); }

    public void deleteUser(Integer id) {repository.deleteById(id);}

    public User findById(Integer id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }
}