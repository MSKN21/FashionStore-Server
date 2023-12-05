package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.ShippingInformation;
import com.example.fashionstore.model.ShippingInformation;
import com.example.fashionstore.service.ShippingInformationService;
import com.example.fashionstore.service.ShippingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShippingInformationController {

    @Autowired
    private ShippingInformationService shippingInformationService;

    @GetMapping("/getShippingInfoOfOrder/{orderId}")
    public ResponseEntity<?> getShippingInfoOfOrder(@PathVariable Integer orderId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<ShippingInformation> shippingInformationList = shippingInformationService.getShippingInformationOfOrder(orderId);
            response.put("ShippingInformationList",shippingInformationList);
            response.put("Message","Shipping Information Of Order Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }   

    @PostMapping("/createShippingInformation/{orderId}")
    public ResponseEntity<?> createShippingInformation(@PathVariable Integer orderId,@RequestBody ShippingInformation shippingInformation){
        Map<String, Object> response=new HashMap<>();
        try {
            ShippingInformation newShippingInformation = shippingInformationService.createShippingInformation(orderId,shippingInformation);
            response.put("NewShippingInformation",newShippingInformation);
            response.put("Message","Created Shipping Information Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateShippingInformation")
    public ResponseEntity<?> updateShippingInformation(@RequestBody ShippingInformation shippingInformation){
        Map<String, Object> response=new HashMap<>();
        try {
            ShippingInformation updatedShippingInformation=shippingInformationService.updateShippingInformation(shippingInformation);
            response.put("UpdatedShippingInformation",updatedShippingInformation);
            response.put("Message","Updated ShippingInformation Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteShippingInformation")
    public ResponseEntity<?> deleteShippingInformation(@RequestBody ShippingInformation shippingInformation){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=shippingInformationService.deleteShippingInformation(shippingInformation);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
