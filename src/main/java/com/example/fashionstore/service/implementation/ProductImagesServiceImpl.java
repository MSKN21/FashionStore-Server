package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ProductImages;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.repository.ProductImagesRepository;
import com.example.fashionstore.repository.ProductsRepository;
import com.example.fashionstore.service.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImagesServiceImpl implements ProductImagesService {

    @Autowired
    private ProductImagesRepository productImagesRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<ProductImages> getProductImagesByProduct(Integer productId) {
        try {
            Products product = productsRepository.findById(productId).get();
            List<ProductImages>productImagesList = productImagesRepository.findByProducts(product);
            return productImagesList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ProductImages getProductImageById(Integer productImageId) {
        try {
            ProductImages productImage = productImagesRepository.findById(productImageId).get();
            return productImage;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ProductImages createProductImage(Integer productId, ProductImages productImages) {
        try {
            Products product = productsRepository.findById(productId).get();
            ProductImages tempProductImages = new ProductImages();
            tempProductImages.setImage(productImages.getImage());
            tempProductImages.setProducts(product);
            ProductImages newProductImage = productImagesRepository.save(tempProductImages);
            return newProductImage;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ProductImages updateProductImage(ProductImages productImages) {
        try {
            ProductImages tempProductImages = productImagesRepository.findById(productImages.getProductImageId()).get();
            tempProductImages.setImage(productImages.getImage());
            ProductImages updatedProductImage = productImagesRepository.save(tempProductImages);
            return updatedProductImage;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteProductImage(ProductImages productImages) {
        try {
            productImagesRepository.deleteById(productImages.getProductImageId());
            return "Deleted Product Image Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
