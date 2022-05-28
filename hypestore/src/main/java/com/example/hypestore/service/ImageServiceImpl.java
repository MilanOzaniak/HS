package com.example.hypestore.service;

import com.example.hypestore.model.Images;
import com.example.hypestore.model.User;
import com.example.hypestore.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserService userService;

    @Override
    public Images createImage(Images image) {
        User currentUser = userService.getCurrentUser();
        image.setUser(currentUser);
        return imageRepository.save(image);
    }

    @Override
    public List<Images> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public void deleteImageById(int id) {
        imageRepository.deleteById(id);
    }
}
