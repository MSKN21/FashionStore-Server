package com.example.fashionstore.repository;

import com.example.fashionstore.model.Seller;
import com.example.fashionstore.model.SellerRatings;
import com.example.fashionstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRatingsRepository extends JpaRepository<SellerRatings,Integer> {
    List<SellerRatings> findBySeller(Seller seller);

    List<SellerRatings> findByUser(User user);

    List<SellerRatings> findByUserAndSeller(User user, Seller seller);
}
