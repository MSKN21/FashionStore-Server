package com.example.fashionstore.service;

import com.example.fashionstore.model.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductsService {

    public List<Products> getProducts();

    public Products getProductById(Integer productId);

    public Products createProduct(Products product);

    public Products updateProduct(Products product);

    public String deleteProduct(Products product);

}
