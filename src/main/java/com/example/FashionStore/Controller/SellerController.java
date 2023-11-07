package com.example.FashionStore.Controller;

import com.example.FashionStore.Model.Seller;
import com.example.FashionStore.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("/getSellers")
    public ResponseEntity<?> getSellers(){
        return sellerService.getSellers();
    }

    @GetMapping("/getSellerById/{sellerId}")
    public ResponseEntity<?> getSellerById(@PathVariable Integer sellerId){
        return sellerService.getSellerById(sellerId);
    }

    @PostMapping("/createSeller")
    public ResponseEntity<?> createSeller(@RequestBody Seller seller){
        return sellerService.createSeller(seller);
    }

    @PutMapping("/updateSeller")
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller){
        return sellerService.updateSeller(seller);
    }

    @DeleteMapping("/deleteSeller")
    public ResponseEntity<?> deleteSeller(@RequestBody Seller seller){
        return sellerService.deleteSeller(seller);
    }

}
