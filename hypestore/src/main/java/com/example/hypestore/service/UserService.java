package com.example.hypestore.service;

import com.example.hypestore.model.Images;
import com.example.hypestore.model.User;

import java.util.List;

public interface UserService {
    String registerUser(User user);
    List<User> getAllUsers();
    void deleteUserById(int id);
    User getCurrentUser();
    List<Images> getImagesForCurrentUser();
}
