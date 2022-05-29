package com.example.hypestore.service;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.User;
import com.example.hypestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(User user) {
        if(!userRepository.existsByUserName(user.getUserName())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles("ROLE_USER");
            userRepository.save(user);
            return "User registered";
        }
        return "User already exist";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(int id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserName(username).get();
    }

    @Override
    public List<Item> getImagesForCurrentUser() {
        return userRepository.findByUserName(getCurrentUser().getUserName()).get().getImages();
    }
}
