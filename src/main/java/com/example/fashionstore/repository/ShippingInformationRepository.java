package com.example.fashionstore.repository;

import com.example.fashionstore.model.Orders;
import com.example.fashionstore.model.ShippingInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingInformationRepository extends JpaRepository<ShippingInformation,Integer> {
    List<ShippingInformation> findByOrder(Orders order);
}
