package com.example.fashionstore.service;

import com.example.fashionstore.model.Wishlist;

import java.util.List;

public interface WishlistService {

    public List<Wishlist> getWishlistProductsByUser(Integer userId);

    public Boolean hasProductInWishlist(Integer userId,Integer productId);

    public Wishlist getWishlistProductById(Integer wishlistId);

    public Wishlist addProductToWishlist(Integer userId,Integer productId);

    public String deleteProductInWishlist(Wishlist wishlist);

}
