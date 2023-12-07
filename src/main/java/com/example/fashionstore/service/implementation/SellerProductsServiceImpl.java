package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.model.Seller;
import com.example.fashionstore.model.SellerProducts;
import com.example.fashionstore.model.SellerRatings;
import com.example.fashionstore.repository.ProductsRepository;
import com.example.fashionstore.repository.SellerProductsRepository;
import com.example.fashionstore.repository.SellerRepository;
import com.example.fashionstore.service.SellerProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerProductsServiceImpl implements SellerProductsService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private SellerProductsRepository sellerProductsRepository;


    @Override
    public List<SellerProducts> getSellerProductsBySeller(Integer sellerId) {
        try {
            Seller seller = sellerRepository.findById(sellerId).get();
            List<SellerProducts>sellerProductsList = sellerProductsRepository.findBySeller(seller);
            return sellerProductsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public List<SellerProducts> getSellerProductsByProduct(Integer productId) {
        try {
            Products products = productsRepository.findById(productId).get();
            List<SellerProducts>sellerProductsList = sellerProductsRepository.findByProducts(products);
            return sellerProductsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public List<SellerProducts> getSellerProductsBySellerAndProduct(Integer sellerId, Integer productId) {
        try {
            Seller seller = sellerRepository.findById(sellerId).get();
            Products products = productsRepository.findById(productId).get();
            List<SellerProducts>sellerProductsList = sellerProductsRepository.findBySellerAndProducts(seller,products);
            return sellerProductsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public SellerProducts getSellerProductsById(Integer sellerProductId) {
        try {
            SellerProducts sellerProducts = sellerProductsRepository.findById(sellerProductId).get();
            return sellerProducts;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public SellerProducts createSellerProducts(Integer sellerId, Integer productId, SellerProducts sellerProducts) {
        try {
            Seller seller = sellerRepository.findById(sellerId).get();
            Products products = productsRepository.findById(productId).get();
            SellerProducts tempSellerProducts = new SellerProducts();
            tempSellerProducts.setPrice(sellerProducts.getPrice());
            tempSellerProducts.setStockQuantity(sellerProducts.getStockQuantity());
            tempSellerProducts.setProducts(products);
            tempSellerProducts.setSeller(seller);
            SellerProducts newSellerProducts = sellerProductsRepository.save(tempSellerProducts);
            return newSellerProducts;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public SellerProducts updateSellerProducts(SellerProducts sellerProducts) {
        try {
            SellerProducts tempSellerProducts = sellerProductsRepository.findById(sellerProducts.getSellerProductId()).get();
            tempSellerProducts.setPrice(sellerProducts.getPrice());
            tempSellerProducts.setStockQuantity(sellerProducts.getStockQuantity());
            SellerProducts updatedSellerProducts = sellerProductsRepository.save(tempSellerProducts);
            return updatedSellerProducts;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteSellerProducts(SellerProducts sellerProducts) {
        try {
            sellerProductsRepository.deleteById(sellerProducts.getSellerProductId());
            return "Successfully Deleted SellerProduct";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
