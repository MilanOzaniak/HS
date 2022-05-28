package com.example.hypestore.controller;

import com.example.hypestore.model.Images;
import com.example.hypestore.service.ImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/images")
@RestController
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/create")
    public Images createImage(@RequestBody Images image){
        return imageService.createImage(image);
    }

    @GetMapping("/allImages")
    public List<Images> listOfImages(){
        return imageService.getAllImages();
    }

    @DeleteMapping("/deleteImage/{id}")
    public void deleteImage(@PathVariable Integer id){
        imageService.deleteImageById(id);
    }

}
