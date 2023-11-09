package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Seller;
import com.example.fashionstore.repository.SellerRepository;
import com.example.fashionstore.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Override
    public List<Seller> getSellers() {
        try{
            List<Seller> sellerList=new ArrayList<>();
            sellerList=sellerRepository.findAll();
            return sellerList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Seller getSellerById(Integer sellerId) {
        try{
            Seller seller = sellerRepository.findById(sellerId).get();
            return seller;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Seller createSeller(Seller seller) {
        try {
            Seller newSeller=sellerRepository.save(seller);
            return newSeller;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Seller updateSeller(Seller seller) {
        Seller newSeller;
        try{
            newSeller = sellerRepository.findById(seller.getSellerId()).get();
            newSeller.setSellerEmail(seller.getSellerEmail());
            newSeller.setSellerName(seller.getSellerName());
            newSeller.setSellerPassword(seller.getSellerPassword());
            newSeller.setSellerPic(seller.getSellerPic());
            newSeller.setSellerPhone(seller.getSellerPhone());
            newSeller.setSellerAddress(seller.getSellerAddress());
            Seller updatedSeller=sellerRepository.save(newSeller);
            return updatedSeller;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteSeller(Seller seller) {
        try{
            sellerRepository.deleteById(seller.getSellerId());
            return "Deleted Seller Successfully";

        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
