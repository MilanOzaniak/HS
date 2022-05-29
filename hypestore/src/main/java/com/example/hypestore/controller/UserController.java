package com.example.hypestore.controller;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.User;
import com.example.hypestore.service.ItemService;
import com.example.hypestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String add(@RequestBody User user){
        userService.registerUser(user);
        return "User was created";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/del/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {

        userService.deleteUserById(id);
        return "User was deleted";
    }

    @GetMapping("/getItems")
    public List<Item> getImages(){
        return userService.getImagesForCurrentUser();
    }




}
