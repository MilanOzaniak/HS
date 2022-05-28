package com.example.hypestore.service;

import com.example.hypestore.model.Images;
import com.example.hypestore.model.User;

import java.util.List;

public interface ImageService {
    Images createImage(Images image);
    List<Images> getAllImages();
    void deleteImageById(int id);
}
