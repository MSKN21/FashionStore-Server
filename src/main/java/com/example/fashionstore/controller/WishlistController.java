package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.User;
import com.example.fashionstore.model.Wishlist;
import com.example.fashionstore.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/getWishlistProductsByUser/{userId}")
    public ResponseEntity<?> getWishlistProductsByUser(@PathVariable Integer userId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<Wishlist> wishlistList = wishlistService.getWishlistProductsByUser(userId);
            response.put("WishlistList",wishlistList);
            response.put("Message","Wishlist Products Of User Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hasProductInWishlist/{userId}/{productId}")
    public ResponseEntity<?> hasProductInWishlist(@PathVariable Integer userId,@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            boolean present = wishlistService.hasProductInWishlist(userId,productId);
            response.put("Present",present);
            response.put("Message","Successfully Searched Whether The Product is Present or not");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getWishlistProductById/{wishlistId}")
    public ResponseEntity<?> getWishlistProductById(@PathVariable Integer wishlistId){
        Map<String, Object> response=new HashMap<>();
        try {
            Wishlist wishlist = wishlistService.getWishlistProductById(wishlistId);
            response.put("Wishlist",wishlist);
            response.put("Message","Wishlist Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addProductToWishlist/{userId}/{productId}")
    public ResponseEntity<?> addProductToWishlist(@PathVariable Integer userId,@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            Wishlist newWishlist = wishlistService.addProductToWishlist(userId,productId);
            response.put("NewWishlist",newWishlist);
            response.put("Message","Product Added To Wishlist Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProductInWishlist")
    public ResponseEntity<?> deleteProductInWishlist(@RequestBody Wishlist wishlist){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=wishlistService.deleteProductInWishlist(wishlist);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
