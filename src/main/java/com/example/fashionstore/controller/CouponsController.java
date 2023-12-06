package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Coupons;
import com.example.fashionstore.model.User;
import com.example.fashionstore.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CouponsController {

    @Autowired
    private CouponsService couponsService;

    @GetMapping("/getCoupons")
    public ResponseEntity<?> getCoupons(){
        Map<String, Object> response=new HashMap<>();
        try {
            List<Coupons> couponsList = couponsService.getCoupons();
            response.put("CouponsList",couponsList);
            response.put("Message","Coupons Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCouponById/{couponsId}")
    public ResponseEntity<?> getCouponById(@PathVariable Integer couponsId){
        Map<String, Object> response=new HashMap<>();
        try {
            Coupons coupons = couponsService.getCouponById(couponsId);
            response.put("Coupons",coupons);
            response.put("Message","Coupon Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createCoupon")
    public ResponseEntity<?> createCoupon(@RequestBody Coupons coupons){
        Map<String, Object> response=new HashMap<>();
        try {
            Coupons newCoupons = couponsService.createCoupon(coupons);
            response.put("NewCoupons",newCoupons);
            response.put("Message","Created New Coupon Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCoupon")
    public ResponseEntity<?> updateCoupon(@RequestBody Coupons coupons){
        Map<String, Object> response=new HashMap<>();
        try {
            Coupons updatedCoupons=couponsService.updateCoupon(coupons);
            response.put("UpdatedCoupon",updatedCoupons);
            response.put("Message","Updated Coupon Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCoupon")
    public ResponseEntity<?> deleteCoupon(@RequestBody Coupons coupons){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=couponsService.deleteCoupon(coupons);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
