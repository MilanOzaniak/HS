package com.example.hypestore.service;

import com.example.hypestore.model.Item;

import java.util.List;

public interface ItemService {
    Item createImage(Item image);
    List<Item> getAllImages();
    void deleteImageById(int id);
}
