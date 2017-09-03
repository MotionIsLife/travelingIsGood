package com.prikhodko.springbootwithjpaandh2.controller;

import com.prikhodko.springbootwithjpaandh2.entity.User;
import com.prikhodko.springbootwithjpaandh2.entity.request.AddUserRequest;
import com.prikhodko.springbootwithjpaandh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        userRepository.save(user);
    }

    @RequestMapping(value = "/names/{name}", method = RequestMethod.GET)
    public List<User> findAllByName(@PathVariable("name") String name) {
        return userRepository.findAllByName(name);
    }
}
