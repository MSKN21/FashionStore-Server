package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.OrderItems;
import com.example.fashionstore.model.Orders;
import com.example.fashionstore.service.OrderItemsService;
import com.example.fashionstore.utils.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping("/getOrderItemsByOrder/{orderId}")
    public ResponseEntity<?> getOrderItemsByOrder(@PathVariable Integer orderId){
        Map<String, Object> response=new HashMap<>();
        try {
            List<OrderItems> orderItemsList = orderItemsService.getOrderItemsByOrder(orderId);
            response.put("OrderItemsList",orderItemsList);
            response.put("Message","Order Items List Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getOrderItemById/{orderItemsId}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Integer orderItemsId){
        Map<String, Object> response=new HashMap<>();
        try {
            OrderItems orderItems = orderItemsService.getOrderItemById(orderItemsId);
            response.put("OrderItems",orderItems);
            response.put("Message","Order Item Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatedOrderItem")
    public ResponseEntity<?> updatedOrderItem(@RequestBody OrderItems orderItems){
        Map<String, Object> response=new HashMap<>();
        try {
            OrderItems updatedOrderItems = orderItemsService.updatedOrderItem(orderItems);
            response.put("UpdatedOrderItems",updatedOrderItems);
            response.put("Message","Updated Order Item Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteOrderItem")
    public ResponseEntity<?> deleteOrderItem(@RequestBody OrderItems orderItems){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=orderItemsService.deleteOrderItem(orderItems);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
