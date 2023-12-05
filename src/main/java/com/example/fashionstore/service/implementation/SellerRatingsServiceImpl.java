package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.*;
import com.example.fashionstore.repository.*;
import com.example.fashionstore.service.SellerRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerRatingsServiceImpl implements SellerRatingsService {

    @Autowired
    private SellerRatingsRepository sellerRatingsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<SellerRatings> getSellerRatingsBySeller(Integer sellerId) {
        try {
            Seller seller = sellerRepository.findById(sellerId).get();
            List<SellerRatings>sellerRatingsList = sellerRatingsRepository.findBySeller(seller);
            return sellerRatingsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public List<SellerRatings> getSellerRatingsByUser(Integer userId) {
        try {
            User user = userRepository.findById(userId).get();
            List<SellerRatings>sellerRatingsList = sellerRatingsRepository.findByUser(user);
            return sellerRatingsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public List<SellerRatings> getSellerRatingsBySellerAndUser(Integer userId, Integer sellerId) {
        try {
            Seller seller = sellerRepository.findById(sellerId).get();
            User user = userRepository.findById(userId).get();
            List<SellerRatings>sellerRatingsList = sellerRatingsRepository.findByUserAndSeller(user,seller);
            return sellerRatingsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public SellerRatings getSellerRatingsById(Integer sellerRatingId) {
        try {
            SellerRatings sellerRatings = sellerRatingsRepository.findById(sellerRatingId).get();
            return sellerRatings;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public SellerRatings createSellerRatings(Integer sellerId, Integer userId, SellerRatings sellerRatings) {
        try {
            Seller seller = sellerRepository.findById(sellerId).get();
            User user = userRepository.findById(userId).get();
            SellerRatings tempSellerRatings = new SellerRatings();
            tempSellerRatings.setComment(sellerRatings.getComment());
            tempSellerRatings.setRating(sellerRatings.getRating());
            tempSellerRatings.setPostedDate(sellerRatings.getPostedDate());
            tempSellerRatings.setSeller(seller);
            tempSellerRatings.setUser(user);
            SellerRatings newSellerRatings = sellerRatingsRepository.save(tempSellerRatings);
            return newSellerRatings;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public SellerRatings updateSellerRatings(SellerRatings sellerRatings) {
        try {
            SellerRatings tempSellerRatings = sellerRatingsRepository.findById(sellerRatings.getSellerRatingId()).get();
            tempSellerRatings.setComment(sellerRatings.getComment());
            tempSellerRatings.setRating(sellerRatings.getRating());
            tempSellerRatings.setPostedDate(sellerRatings.getPostedDate());
            SellerRatings updatedSellerRatings = sellerRatingsRepository.save(tempSellerRatings);
            return updatedSellerRatings;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteSellerRatings(SellerRatings sellerRatings) {
        try {
            sellerRatingsRepository.deleteById(sellerRatings.getSellerRatingId());
            return "Deleted Seller Rating Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
