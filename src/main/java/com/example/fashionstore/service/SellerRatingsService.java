package com.example.fashionstore.service;

import com.example.fashionstore.model.SellerRatings;

import java.util.List;

public interface SellerRatingsService {

    public List<SellerRatings> getSellerRatingsBySeller(Integer sellerId);

    public List<SellerRatings> getSellerRatingsByUser(Integer userId);

    public List<SellerRatings> getSellerRatingsBySellerAndUser(Integer userId,Integer sellerId);

    public SellerRatings getSellerRatingsById(Integer sellerRatingId);

    public SellerRatings createSellerRatings(Integer sellerId,Integer userId, SellerRatings sellerRatings);

    public SellerRatings updateSellerRatings(SellerRatings sellerRatings);

    public String deleteSellerRatings(SellerRatings sellerRatings);

}
