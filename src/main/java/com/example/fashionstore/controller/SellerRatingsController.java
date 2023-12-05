package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ProductReview;
import com.example.fashionstore.model.SellerRatings;
import com.example.fashionstore.service.ProductReviewService;
import com.example.fashionstore.service.SellerRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SellerRatingsController {

    @Autowired
    private SellerRatingsService sellerRatingsService;

    @GetMapping("/getSellerRatingsBySeller/{sellerId}")
    public ResponseEntity<?> getSellerRatingsBySeller(@PathVariable Integer sellerId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<SellerRatings> sellerRatingsList = sellerRatingsService.getSellerRatingsBySeller(sellerId);
            response.put("SellerRatingsList",sellerRatingsList);
            response.put("Message","All Ratings Of Seller Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerRatingsByUser/{userId}")
    public ResponseEntity<?> getSellerRatingsByUser(@PathVariable Integer userId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<SellerRatings> sellerRatingsList = sellerRatingsService.getSellerRatingsByUser(userId);
            response.put("SellerRatingsList",sellerRatingsList);
            response.put("Message","All Seller Ratings Of User Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerRatingsBySellerAndUser/{userId}/{sellerId}")
    public ResponseEntity<?> getSellerRatingsBySellerAndUser(@PathVariable Integer userId,@PathVariable Integer sellerId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<SellerRatings> sellerRatingsList = sellerRatingsService.getSellerRatingsBySellerAndUser(userId,sellerId);
            response.put("SellerRatingsList",sellerRatingsList);
            response.put("Message","Seller Rating Of User Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerRatingsById/{sellerRatingId}")
    public ResponseEntity<?> getSellerRatingsById(@PathVariable Integer sellerRatingId){
        Map<String, Object> response=new HashMap<>();
        try {
            SellerRatings sellerRatings = sellerRatingsService.getSellerRatingsById(sellerRatingId);
            response.put("SellerRatings",sellerRatings);
            response.put("Message","Seller Rating Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createSellerRatings/{userId}/{sellerId}")
    public ResponseEntity<?> createSellerRatings(@PathVariable Integer sellerId,@PathVariable Integer userId,@RequestBody SellerRatings sellerRatings){
        Map<String, Object> response=new HashMap<>();
        try {
            SellerRatings newSellerRatings = sellerRatingsService.createSellerRatings(sellerId,userId,sellerRatings);
            response.put("NewSellerRatings",newSellerRatings);
            response.put("Message","Created Seller Rating Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSellerRatings")
    public ResponseEntity<?> updateSellerRatings(@RequestBody SellerRatings sellerRatings){
        Map<String, Object> response=new HashMap<>();
        try {
            SellerRatings updatedSellerRatings = sellerRatingsService.updateSellerRatings(sellerRatings);
            response.put("UpdatedSellerRatings",updatedSellerRatings);
            response.put("Message","Updated Seller Rating Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSellerRatings")
    public ResponseEntity<?> deleteSellerRatings(@RequestBody SellerRatings sellerRatings){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=sellerRatingsService.deleteSellerRatings(sellerRatings);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
