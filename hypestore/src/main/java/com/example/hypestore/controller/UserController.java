package com.example.hypestore.controller;

import com.example.hypestore.model.Images;
import com.example.hypestore.model.MyUserDetails;
import com.example.hypestore.model.User;
import com.example.hypestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public String add(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {

        userService.deleteUserById(id);
        return "User was deleted";
    }

    @GetMapping("/getImages")
    public List<Images> getImages(){
        return userService.getImagesForCurrentUser();
    }

}
