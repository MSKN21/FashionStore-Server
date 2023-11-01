package com.example.FashionStore.Repository;

import com.example.FashionStore.Model.SellerRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRatingsRepository extends JpaRepository<SellerRatings,String> {
}
