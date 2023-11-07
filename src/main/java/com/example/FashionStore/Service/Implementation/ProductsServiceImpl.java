package com.example.FashionStore.Service.Implementation;

import com.example.FashionStore.Model.Products;
import com.example.FashionStore.Model.Products;
import com.example.FashionStore.Model.User;
import com.example.FashionStore.Repository.ProductsRepository;
import com.example.FashionStore.Service.ProductsService;
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
    public ResponseEntity<?> getProducts() {
        Map<String, Object> response=new HashMap<>();
        try{
            List<Products> productsList=new ArrayList<>();
            productsList=productsRepository.findAll();
            response.put("ProductsList",productsList);
            response.put("Message","Products Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getProductById(Integer productId) {
        Map<String, Object>response=new HashMap<>();
        try{
            Products product = productsRepository.findById(productId).get();
            if(product == null) throw new NullPointerException("Product Not Found");
            response.put("Product",product);
            response.put("Message","Product Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> createProduct(Products product) {
        Map<String, Object>response=new HashMap<>();
        try {
            Products newProduct=productsRepository.save(product);
            response.put("NewProduct",newProduct);
            response.put("Message","Created Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateProduct(Products product) {
        Products newProduct;
        Map<String, Object>response=new HashMap<>();
        try{
            newProduct = productsRepository.findById(product.getProductId()).get();
            if(newProduct == null)
                throw new Exception("Product Not Found");
            newProduct.setDescription(product.getDescription());
            newProduct.setBrandName(product.getBrandName());
            newProduct.setCategory(product.getCategory());
            newProduct.setSize(product.getSize());
            newProduct.setColor(product.getColor());
            newProduct.setStockQuantity(product.getStockQuantity());
            newProduct.setPrice(product.getPrice());
            Products updatedProduct=productsRepository.save(newProduct);

            response.put("UpdatedProduct",updatedProduct);
            response.put("Message","Updated Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteProduct(Products product) {
        Map<String, Object>response=new HashMap<>();
        try{
            productsRepository.deleteById(product.getProductId());
            response.put("Message","Deleted Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
