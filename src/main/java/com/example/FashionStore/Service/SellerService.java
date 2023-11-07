package com.example.FashionStore.Service;

import com.example.FashionStore.Model.Seller;
import org.springframework.http.ResponseEntity;

public interface SellerService {

    public ResponseEntity<?> getSellers();

    public ResponseEntity<?> getSellerById(Integer sellerId);
    public ResponseEntity<?> createSeller(Seller seller);

    public ResponseEntity<?> updateSeller(Seller seller);

    public ResponseEntity<?> deleteSeller(Seller seller);

}
