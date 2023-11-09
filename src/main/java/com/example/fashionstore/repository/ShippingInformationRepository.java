package com.example.fashionstore.repository;

import com.example.fashionstore.model.ShippingInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInformationRepository extends JpaRepository<ShippingInformation,Integer> {
}
