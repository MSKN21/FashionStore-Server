package com.example.fashionstore.service;

import com.example.fashionstore.model.Seller;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SellerService {

    public List<Seller> getSellers();

    public Seller getSellerById(Integer sellerId);
    public Seller createSeller(Seller seller);

    public Seller updateSeller(Seller seller);

    public String deleteSeller(Seller seller);

}
