package com.example.fashionstore.repository;

import com.example.fashionstore.model.OrderItems;
import com.example.fashionstore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
    List<OrderItems> findByOrder(Orders orders);
}
