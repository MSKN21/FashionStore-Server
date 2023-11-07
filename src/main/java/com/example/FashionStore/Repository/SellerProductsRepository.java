package com.example.FashionStore.Repository;

import com.example.FashionStore.Model.SellerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerProductsRepository extends JpaRepository<SellerProducts,Integer> {
}
