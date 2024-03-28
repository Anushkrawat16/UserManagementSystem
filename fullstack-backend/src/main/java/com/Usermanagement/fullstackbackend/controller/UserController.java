package com.Usermanagement.fullstackbackend.controller;

import java.util.List;

import com.Usermanagement.fullstackbackend.exception.UserNotFoundException;
import com.Usermanagement.fullstackbackend.model.user;
import com.Usermanagement.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    user newUser(@RequestBody user newUser){
        return userRepository.save(newUser);
    }
    @GetMapping("/users")
    List<user>getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    user getUserbyId(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/user/{id}")
    user updateUser(@RequestBody user newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
