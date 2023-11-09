package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.*;
import com.example.fashionstore.model.Seller;
import com.example.fashionstore.model.Seller;
import com.example.fashionstore.model.Seller;
import com.example.fashionstore.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("/getSellers")
    public ResponseEntity<?> getSellers(){
        Map<String, Object> response=new HashMap<>();
        try {
            List<Seller> sellerList = sellerService.getSellers();
            response.put("SellerList",sellerList);
            response.put("Message","Sellers Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSellerById/{sellerId}")
    public ResponseEntity<?> getSellerById(@PathVariable Integer sellerId){
        Map<String, Object> response=new HashMap<>();
        try {
            Seller seller = sellerService.getSellerById(sellerId);
            response.put("Seller",seller);
            response.put("Message","Seller Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createSeller")
    public ResponseEntity<?> createSeller(@RequestBody Seller seller){
        Map<String, Object> response=new HashMap<>();
        try {
            Seller newSeller = sellerService.createSeller(seller);
            response.put("NewSeller",newSeller);
            response.put("Message","Created Seller Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSeller")
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller){
        Map<String, Object> response=new HashMap<>();
        try {
            Seller updatedSeller=sellerService.updateSeller(seller);
            response.put("UpdatedSeller",updatedSeller);
            response.put("Message","Updated Seller Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSeller")
    public ResponseEntity<?> deleteSeller(@RequestBody Seller seller){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=sellerService.deleteSeller(seller);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
