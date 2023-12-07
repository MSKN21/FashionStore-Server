package com.example.fashionstore.service;

import com.example.fashionstore.model.SellerProducts;

import java.util.List;

public interface SellerProductsService {

    public List<SellerProducts> getSellerProductsBySeller(Integer sellerId);

    public List<SellerProducts> getSellerProductsByProduct(Integer productId);

    public List<SellerProducts> getSellerProductsBySellerAndProduct(Integer sellerId,Integer productId);

    public SellerProducts getSellerProductsById(Integer sellerProductId);

    public SellerProducts createSellerProducts(Integer sellerId,Integer productId, SellerProducts sellerProducts);

    public SellerProducts updateSellerProducts(SellerProducts sellerProducts);

    public String deleteSellerProducts(SellerProducts sellerProducts);

}
