package com.example.fashionstore.repository;

import com.example.fashionstore.model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons,Integer> {
}
