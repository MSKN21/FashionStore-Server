package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ProductImages;
import com.example.fashionstore.model.SellerProducts;
import com.example.fashionstore.service.SellerProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SellerProductsController {

    @Autowired
    private SellerProductsService sellerProductsService;

    @GetMapping("/getSellerProductsBySeller/{sellerId}")
    public ResponseEntity<?> getSellerProductsBySeller(@PathVariable Integer sellerId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<SellerProducts> sellerProductsList = sellerProductsService.getSellerProductsBySeller(sellerId);
            response.put("SellerProductsList",sellerProductsList);
            response.put("Message","All Products of Seller Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerProductsByProduct/{productId}")
    public ResponseEntity<?> getSellerProductsByProduct(@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<SellerProducts> sellerProductsList = sellerProductsService.getSellerProductsByProduct(productId);
            response.put("SellerProductsList",sellerProductsList);
            response.put("Message","All Sellers of the Product Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerProductsBySellerAndProduct/{sellerId}/{productId}")
    public ResponseEntity<?> getSellerProductsBySellerAndProduct(@PathVariable Integer sellerId,@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<SellerProducts> sellerProductsList = sellerProductsService.getSellerProductsBySellerAndProduct(sellerId,productId);
            response.put("SellerProductsList",sellerProductsList);
            response.put("Message","All Details Of Seller Products Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerProductsById/{sellerProductId}")
    public ResponseEntity<?> getSellerProductsById(@PathVariable Integer sellerProductId){
        Map<String, Object> response=new HashMap<>();
        try {
            SellerProducts sellerProducts = sellerProductsService.getSellerProductsById(sellerProductId);
            response.put("SellerProduct",sellerProducts);
            response.put("Message","Seller's Product Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createSellerProducts/{sellerId}/{productId}")
    public ResponseEntity<?> createSellerProducts(@PathVariable Integer sellerId,@PathVariable Integer productId,@RequestBody SellerProducts sellerProducts){
        Map<String, Object> response=new HashMap<>();
        try {
            SellerProducts newSellerProducts = sellerProductsService.createSellerProducts(sellerId,productId,sellerProducts);
            response.put("NewSellerProducts",newSellerProducts);
            response.put("Message","Created New Seller Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSellerProducts")
    public ResponseEntity<?> updateSellerProducts(@RequestBody SellerProducts sellerProducts){
        Map<String, Object> response=new HashMap<>();
        try {
            SellerProducts updatedSellerProducts=sellerProductsService.updateSellerProducts(sellerProducts);
            response.put("UpdatedSellerProducts",updatedSellerProducts);
            response.put("Message","Updated Seller Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSellerProducts")
    public ResponseEntity<?> deleteSellerProducts(@RequestBody SellerProducts sellerProducts){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=sellerProductsService.deleteSellerProducts(sellerProducts);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
