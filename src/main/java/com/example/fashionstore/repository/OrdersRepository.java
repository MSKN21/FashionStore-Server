package com.example.fashionstore.repository;

import com.example.fashionstore.model.Orders;
import com.example.fashionstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findByUser(User user);
}
