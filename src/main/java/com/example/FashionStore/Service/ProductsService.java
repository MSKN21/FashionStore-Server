package com.example.FashionStore.Service;

import com.example.FashionStore.Model.Products;
import org.springframework.http.ResponseEntity;

public interface ProductsService {

    public ResponseEntity<?> getProducts();

    public ResponseEntity<?> getProductById(Integer productId);

    public ResponseEntity<?> createProduct(Products product);

    public ResponseEntity<?> updateProduct(Products product);

    public ResponseEntity<?> deleteProduct(Products product);

}
