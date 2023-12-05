package com.example.fashionstore.service;

import com.example.fashionstore.model.ProductImages;

import java.util.List;

public interface ProductImagesService {
    public List<ProductImages> getProductImagesByProduct(Integer productId);

    public ProductImages getProductImageById(Integer productImageId);

    ProductImages createProductImage(Integer productId, ProductImages productImages);

    public ProductImages updateProductImage(ProductImages productImages);

    public String deleteProductImage(ProductImages productImages);
}
