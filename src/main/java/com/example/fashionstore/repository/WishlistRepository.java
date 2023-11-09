package com.example.fashionstore.repository;

import com.example.fashionstore.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
}
