package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ProductImages;
import com.example.fashionstore.model.ProductReview;
import com.example.fashionstore.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("/getProductReviewsByProduct/{productId}")
    public ResponseEntity<?> getProductReviewsByProduct(@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<ProductReview> productReviewList = productReviewService.getProductReviewsByProduct(productId);
            response.put("ProductReviewList",productReviewList);
            response.put("Message","All Reviews Of Product Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductReviewsByUser/{userId}")
    public ResponseEntity<?> getProductReviewsByUser(@PathVariable Integer userId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<ProductReview> productReviewList = productReviewService.getProductReviewsByUser(userId);
            response.put("ProductReviewList",productReviewList);
            response.put("Message","All Products Reviews Of User Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductReviewsByProductAndUser/{userId}/{productId}")
    public ResponseEntity<?> getProductReviewsByProductAndUser(@PathVariable Integer userId,@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<ProductReview> productReviewList = productReviewService.getProductReviewsByProductAndUser(userId,productId);
            response.put("ProductReviewList",productReviewList);
            response.put("Message","Product Review Of User Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductReviewById/{productReviewId}")
    public ResponseEntity<?> getProductReviewById(@PathVariable Integer productReviewId){
        Map<String, Object> response=new HashMap<>();
        try {
            ProductReview productReview= productReviewService.getProductReviewById(productReviewId);
            response.put("ProductReview",productReview);
            response.put("Message","Product Review Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createProductReview/{userId}/{productId}")
    public ResponseEntity<?> createProductReview(@PathVariable Integer userId,@PathVariable Integer productId,@RequestBody ProductReview productReview){
        Map<String, Object> response=new HashMap<>();
        try {
            ProductReview newProductReview = productReviewService.createProductReview(userId,productId,productReview);
            response.put("NewProductReview",newProductReview);
            response.put("Message","Created Product Review Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProductReview")
    public ResponseEntity<?> updateProductReview(@RequestBody ProductReview productReview){
        Map<String, Object> response=new HashMap<>();
        try {
            ProductReview updateProductReview = productReviewService.updateProductReview(productReview);
            response.put("UpdateProductReview",updateProductReview);
            response.put("Message","Updated Product Review Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProductReview")
    public ResponseEntity<?> deleteProductReview(@RequestBody ProductReview productReview){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=productReviewService.deleteProductReview(productReview);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
