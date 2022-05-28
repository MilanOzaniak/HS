package com.example.hypestore.repository;

import com.example.hypestore.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends JpaRepository<Images, Integer> {

}
