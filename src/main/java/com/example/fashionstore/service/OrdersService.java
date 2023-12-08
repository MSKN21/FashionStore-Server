package com.example.fashionstore.service;

import com.example.fashionstore.model.Orders;
import com.example.fashionstore.utils.dto.OrdersDto;

import java.util.List;

public interface OrdersService {

    public List<Orders> getAllOrdersOfUser(Integer userId);

    public Orders getOrderById(Integer orderId);

    public Orders createOrder(OrdersDto ordersDto);

    public Orders updatedOrder(OrdersDto ordersDto);

    public String deleteOrder(Integer orderId);

}
