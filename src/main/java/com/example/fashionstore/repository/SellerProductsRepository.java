package com.example.fashionstore.repository;

import com.example.fashionstore.model.Products;
import com.example.fashionstore.model.Seller;
import com.example.fashionstore.model.SellerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerProductsRepository extends JpaRepository<SellerProducts,Integer> {
    List<SellerProducts> findBySeller(Seller seller);

    List<SellerProducts> findByProducts(Products products);

    List<SellerProducts> findBySellerAndProducts(Seller seller, Products products);
}
