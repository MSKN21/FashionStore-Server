package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ProductImages;
import com.example.fashionstore.model.ProductReview;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.model.User;
import com.example.fashionstore.repository.ProductReviewRepository;
import com.example.fashionstore.repository.ProductsRepository;
import com.example.fashionstore.repository.UserRepository;
import com.example.fashionstore.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<ProductReview> getProductReviewsByProduct(Integer productId) {
        try {
            Products product = productsRepository.findById(productId).get();
            List<ProductReview>productReviewList = productReviewRepository.findByProducts(product);
            return productReviewList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public List<ProductReview> getProductReviewsByUser(Integer userId) {
        try {
            User user = userRepository.findById(userId).get();
            List<ProductReview>productReviewList = productReviewRepository.findByUser(user);
            return productReviewList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public List<ProductReview> getProductReviewsByProductAndUser(Integer userId, Integer productId) {
        try {
            Products product = productsRepository.findById(productId).get();
            User user = userRepository.findById(userId).get();
            List<ProductReview>productReviewList = productReviewRepository.findByProductsAndUser(product,user);
            return productReviewList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ProductReview getProductReviewById(Integer productReviewId) {
        try {
            ProductReview productReview = productReviewRepository.findById(productReviewId).get();
            return productReview;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ProductReview createProductReview(Integer productId, Integer userId, ProductReview productReview) {
        try {
            Products product = productsRepository.findById(productId).get();
            User user = userRepository.findById(userId).get();
            ProductReview tempProductReview = new ProductReview();
            tempProductReview.setComment(productReview.getComment());
            tempProductReview.setRating(productReview.getRating());
            tempProductReview.setPostedDate(productReview.getPostedDate());
            tempProductReview.setProducts(product);
            tempProductReview.setUser(user);
            ProductReview newProductReview = productReviewRepository.save(tempProductReview);
            return newProductReview;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ProductReview updateProductReview(ProductReview productReview) {
        try {
            ProductReview tempProductReview = productReviewRepository.findById(productReview.getProductReviewId()).get();
            tempProductReview.setComment(productReview.getComment());
            tempProductReview.setRating(productReview.getRating());
            tempProductReview.setPostedDate(productReview.getPostedDate());
            ProductReview updatedProductReview = productReviewRepository.save(tempProductReview);
            return updatedProductReview;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteProductReview(ProductReview productReview) {
        try {
            productReviewRepository.deleteById(productReview.getProductReviewId());
            return "Deleted Product Review Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
