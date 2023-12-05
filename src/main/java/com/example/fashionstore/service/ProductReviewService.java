package com.example.fashionstore.service;

import com.example.fashionstore.model.ProductReview;

import java.util.List;

public interface ProductReviewService {
    public List<ProductReview> getProductReviewsByProduct(Integer productId);

    public List<ProductReview> getProductReviewsByUser(Integer userId);

    public List<ProductReview> getProductReviewsByProductAndUser(Integer userId,Integer productId);

    public ProductReview getProductReviewById(Integer productReviewId);

    public ProductReview createProductReview(Integer productId,Integer userId, ProductReview productReview);

    public ProductReview updateProductReview(ProductReview productReview);

    public String deleteProductReview(ProductReview productReview);
}
