package com.example.fashionstore.repository;

import com.example.fashionstore.model.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages,Integer> {
}
