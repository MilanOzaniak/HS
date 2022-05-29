package com.example.hypestore.controller;

import com.example.hypestore.model.Item;
import com.example.hypestore.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item")
@RestController
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService imageService) {
        this.itemService = imageService;
    }

    @PostMapping("/create")
    public Item createImage(@RequestBody Item image){
        return itemService.createImage(image);
    }

    @GetMapping("/getAll")
    public List<Item> listOfImages(){
        return itemService.getAllImages();
    }

    @DeleteMapping("/del/{id}")
    public void deleteImage(@PathVariable Integer id){
        itemService.deleteImageById(id);
    }

}
