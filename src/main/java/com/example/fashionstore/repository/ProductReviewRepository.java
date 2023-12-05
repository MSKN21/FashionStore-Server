package com.example.fashionstore.repository;

import com.example.fashionstore.model.ProductReview;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview,Integer> {
    List<ProductReview> findByProducts(Products product);

    List<ProductReview> findByProductsAndUser(Products product, User user);

    List<ProductReview> findByUser(User user);
}
