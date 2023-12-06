package com.example.fashionstore.repository;

import com.example.fashionstore.model.Products;
import com.example.fashionstore.model.User;
import com.example.fashionstore.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
    List<Wishlist> findByUser(User user);

    List<Wishlist> findByUserAndProduct(User user, Products product);
}
