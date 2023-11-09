package com.example.fashionstore.repository;

import com.example.fashionstore.model.SellerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerProductsRepository extends JpaRepository<SellerProducts,Integer> {
}
