package com.example.fashionstore.service;

import com.example.fashionstore.model.OrderItems;

import java.util.List;

public interface OrderItemsService {

    public List<OrderItems> getOrderItemsByOrder(Integer orderId);

    public OrderItems getOrderItemById(Integer orderItemsId);

    public OrderItems updatedOrderItem(OrderItems orderItems);

    public String deleteOrderItem(OrderItems orderItems);

}
