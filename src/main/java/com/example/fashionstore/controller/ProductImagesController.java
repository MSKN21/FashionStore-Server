package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ProductImages;
import com.example.fashionstore.service.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductImagesController {

    @Autowired
    private ProductImagesService productImagesService;

    @GetMapping("/getProductImagesByProduct/{productId}")
    public ResponseEntity<?> getProductImagesByProduct(@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<ProductImages> productImagesList = productImagesService.getProductImagesByProduct(productId);
            response.put("ProductImagesList",productImagesList);
            response.put("Message","Images Of Product Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductImageById/{productImageId}")
    public ResponseEntity<?> getProductImageById(@PathVariable Integer productImageId){
        Map<String, Object> response=new HashMap<>();
        try {
            ProductImages productImage = productImagesService.getProductImageById(productImageId);
            response.put("ProductImage",productImage);
            response.put("Message","Image Of Product Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createProductImage/{productId}")
    public ResponseEntity<?> createProductImage(@PathVariable Integer productId,@RequestBody ProductImages ProductImages){
        Map<String, Object> response=new HashMap<>();
        try {
            ProductImages newProductImage = productImagesService.createProductImage(productId,ProductImages);
            response.put("NewProductImage",newProductImage);
            response.put("Message","Created Product Image Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProductImage")
    public ResponseEntity<?> updateProductImage(@RequestBody ProductImages productImages){
        Map<String, Object> response=new HashMap<>();
        try {
            ProductImages updatedProductImage=productImagesService.updateProductImage(productImages);
            response.put("UpdatedProductImage",updatedProductImage);
            response.put("Message","Updated Product Image Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProductImage")
    public ResponseEntity<?> deleteProductImage(@RequestBody ProductImages productImages){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=productImagesService.deleteProductImage(productImages);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
