package com.example.hypestore.service;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.User;
import com.example.hypestore.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserService userService;

    @Override
    public Item createImage(Item image) {
        User currentUser = userService.getCurrentUser();
        image.setUser(currentUser);
        return itemRepository.save(image);
    }

    @Override
    public List<Item> getAllImages() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteImageById(int id) {
        itemRepository.deleteById(id);
    }
}
