package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.repository.ProductsRepository;
import com.example.fashionstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getProducts() {
        try{
            List<Products> productsList=new ArrayList<>();
            productsList=productsRepository.findAll();
            return productsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Products getProductById(Integer productId) {
        try{
            Products product = productsRepository.findById(productId).get();
            return product;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Products createProduct(Products product) {
        try {
            Products newProduct=productsRepository.save(product);
            return newProduct;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Products updateProduct(Products product) {
        Products newProduct;
        try{
            newProduct = productsRepository.findById(product.getProductId()).get();
            newProduct.setDescription(product.getDescription());
            newProduct.setBrandName(product.getBrandName());
            newProduct.setCategory(product.getCategory());
            newProduct.setSize(product.getSize());
            newProduct.setColor(product.getColor());
            newProduct.setStockQuantity(product.getStockQuantity());
            newProduct.setPrice(product.getPrice());
            Products updatedProduct=productsRepository.save(newProduct);
            return updatedProduct;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteProduct(Products product) {
        try{
            productsRepository.deleteById(product.getProductId());
            return "Deleted Product Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
