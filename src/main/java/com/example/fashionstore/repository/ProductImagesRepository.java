package com.example.fashionstore.repository;

import com.example.fashionstore.model.ProductImages;
import com.example.fashionstore.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages,Integer> {
    List<ProductImages> findByProducts(Products product);
}
