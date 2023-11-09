package com.example.fashionstore.repository;

import com.example.fashionstore.model.SellerRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRatingsRepository extends JpaRepository<SellerRatings,Integer> {
}
