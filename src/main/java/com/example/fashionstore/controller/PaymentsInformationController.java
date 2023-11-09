package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.PaymentsInformation;
import com.example.fashionstore.service.PaymentsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/PaymentsInfo")
public class PaymentsInformationController {

    @Autowired
    private PaymentsInformationService paymentsInformationService;

    @GetMapping("/getPaymentInfoOfUser/{userId}")
    public ResponseEntity<?> getPaymentInfoOfUser(@PathVariable Integer userId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<PaymentsInformation> paymentsInformationList = paymentsInformationService.getPaymentInfoOfUser(userId);
            response.put("PaymentsInformationList",paymentsInformationList);
            response.put("Message","Payments Information Of User Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createPaymentsInformation/{userId}")
    public ResponseEntity<?> createPaymentsInformation(@PathVariable Integer userId,@RequestBody PaymentsInformation paymentsInformation){
        Map<String, Object> response=new HashMap<>();
        try {
            PaymentsInformation newPaymentsInformation = paymentsInformationService.createPaymentsInformation(userId,paymentsInformation);
            response.put("NewPaymentsInformation",newPaymentsInformation);
            response.put("Message","Created Payments Information Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePaymentsInformation")
    public ResponseEntity<?> updatePaymentsInformation(@RequestBody PaymentsInformation paymentsInformation){
        Map<String, Object> response=new HashMap<>();
        try {
            PaymentsInformation updatedPaymentsInformation=paymentsInformationService.updatePaymentsInformation(paymentsInformation);
            response.put("UpdatedPaymentsInformation",updatedPaymentsInformation);
            response.put("Message","Updated PaymentsInformation Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePaymentsInformation")
    public ResponseEntity<?> deletePaymentsInformation(@RequestBody PaymentsInformation paymentsInformation){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=paymentsInformationService.deletePaymentsInformation(paymentsInformation);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
