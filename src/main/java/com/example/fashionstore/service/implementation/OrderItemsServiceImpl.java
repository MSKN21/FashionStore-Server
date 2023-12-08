package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.OrderItems;
import com.example.fashionstore.model.Orders;
import com.example.fashionstore.repository.OrderItemsRepository;
import com.example.fashionstore.repository.OrdersRepository;
import com.example.fashionstore.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public List<OrderItems> getOrderItemsByOrder(Integer orderId) {
        try{
            Orders orders = ordersRepository.findById(orderId).get();
            List<OrderItems> orderItemsList = orderItemsRepository.findByOrder(orders);
            return orderItemsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public OrderItems getOrderItemById(Integer orderItemsId) {
        try{
            OrderItems orderItem = orderItemsRepository.findById(orderItemsId).get();
            return orderItem;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public OrderItems updatedOrderItem(OrderItems orderItems) {
        try{
            OrderItems tempOrderItem = orderItemsRepository.findById(orderItems.getOrderItemsId()).get();
            tempOrderItem.setQuantity(orderItems.getQuantity());
            tempOrderItem.setSubTotal(orderItems.getSubTotal());
            tempOrderItem.setProducts(orderItems.getProducts());
            OrderItems updatedOrderItems = orderItemsRepository.save(tempOrderItem);
            return updatedOrderItems;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteOrderItem(OrderItems orderItems) {
        try{
            orderItemsRepository.deleteById(orderItems.getOrderItemsId());
            return "Deleted Order Item Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
