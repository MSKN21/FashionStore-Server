package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Coupons;
import com.example.fashionstore.model.Orders;
import com.example.fashionstore.service.OrdersService;
import com.example.fashionstore.utils.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/getAllOrdersOfUser/{userId}")
    public ResponseEntity<?> getAllOrdersOfUser(@PathVariable Integer userId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<Orders> ordersList = ordersService.getAllOrdersOfUser(userId);
            response.put("OrdersList",ordersList);
            response.put("Message","Orders List Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer orderId){
        Map<String, Object> response=new HashMap<>();
        try {
            Orders orders = ordersService.getOrderById(orderId);
            response.put("Orders",orders);
            response.put("Message","Order Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrdersDto ordersDto){
        Map<String, Object> response=new HashMap<>();
        try {
            Orders newOrder = ordersService.createOrder(ordersDto);
            response.put("NewOrder",newOrder);
            response.put("Message","Created New Order Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatedOrder")
    public ResponseEntity<?> updatedOrder(@RequestBody OrdersDto ordersDto){
        Map<String, Object> response=new HashMap<>();
        try {
            Orders updatedOrder = ordersService.updatedOrder(ordersDto);
            response.put("UpdatedOrder",updatedOrder);
            response.put("Message","Updated Order Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=ordersService.deleteOrder(orderId);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
