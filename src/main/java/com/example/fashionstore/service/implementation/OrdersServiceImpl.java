package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.OrderItems;
import com.example.fashionstore.model.Orders;
import com.example.fashionstore.model.User;
import com.example.fashionstore.repository.OrderItemsRepository;
import com.example.fashionstore.repository.OrdersRepository;
import com.example.fashionstore.repository.UserRepository;
import com.example.fashionstore.service.OrdersService;
import com.example.fashionstore.utils.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public List<Orders> getAllOrdersOfUser(Integer userId) {
        try{
            User user = userRepository.findById(userId).get();
            List<Orders>ordersList = ordersRepository.findByUser(user);
            return ordersList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Orders getOrderById(Integer orderId) {
        try{
            Orders order = ordersRepository.findById(orderId).get();
            return order;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Orders createOrder(OrdersDto ordersDto) {
        try{
            User user = userRepository.findById(ordersDto.getUserId()).get();
            Orders tempOrder = new Orders();
            tempOrder.setOrderDate(ordersDto.getOrderDate());
            tempOrder.setStatus(ordersDto.getStatus());
            tempOrder.setUser(user);
            Orders newOrder = ordersRepository.save(tempOrder);
            List<OrderItems>orderItemsList = ordersDto.getOrderItemsList();
            orderItemsList.forEach(orderItem -> {
                OrderItems tempOrderItem = new OrderItems();
                tempOrderItem.setQuantity(orderItem.getQuantity());
                tempOrderItem.setSubTotal(orderItem.getSubTotal());
                tempOrderItem.setOrders(newOrder);
                tempOrderItem.setProducts(orderItem.getProducts());
                orderItemsRepository.save(tempOrderItem);
            });
            return newOrder;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Orders updatedOrder(OrdersDto ordersDto) {
        try{
            Orders tempOrder = ordersRepository.findById(ordersDto.getUserId()).get();
            tempOrder.setOrderDate(ordersDto.getOrderDate());
            tempOrder.setStatus(ordersDto.getStatus());
            Orders updatedOrder = ordersRepository.save(tempOrder);
            List<OrderItems>orderItemsList = ordersDto.getOrderItemsList();
            orderItemsList.forEach(orderItem -> {
                OrderItems tempOrderItem = new OrderItems();
                tempOrderItem.setQuantity(orderItem.getQuantity());
                tempOrderItem.setSubTotal(orderItem.getSubTotal());
                tempOrderItem.setOrders(updatedOrder);
                tempOrderItem.setProducts(orderItem.getProducts());
                orderItemsRepository.save(tempOrderItem);
            });
            return updatedOrder;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteOrder(Integer orderId) {
        try{
            ordersRepository.deleteById(orderId);
            return "Deleted Order Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
