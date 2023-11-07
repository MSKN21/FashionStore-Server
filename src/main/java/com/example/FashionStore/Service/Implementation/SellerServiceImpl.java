package com.example.FashionStore.Service.Implementation;

import com.example.FashionStore.Model.Seller;
import com.example.FashionStore.Model.Seller;
import com.example.FashionStore.Model.Seller;
import com.example.FashionStore.Repository.SellerRepository;
import com.example.FashionStore.Service.SellerService;
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
    public ResponseEntity<?> getSellers() {
        Map<String, Object> response=new HashMap<>();
        try{
            List<Seller> sellerList=new ArrayList<>();
            sellerList=sellerRepository.findAll();
            response.put("SellersList",sellerList);
            response.put("Message","Sellers Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getSellerById(Integer sellerId) {
        Map<String, Object>response=new HashMap<>();
        try{
            Seller seller = sellerRepository.findById(sellerId).get();
            if(seller == null) throw new NullPointerException("Seller Not Found");
            response.put("Seller",seller);
            response.put("Message","Seller Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> createSeller(Seller seller) {
        Map<String, Object>response=new HashMap<>();
        try {
            Seller newSeller=sellerRepository.save(seller);
            response.put("NewSeller",newSeller);
            response.put("Message","Created Seller Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateSeller(Seller seller) {
        Seller newSeller;
        Map<String, Object>response=new HashMap<>();
        try{
            newSeller = sellerRepository.findById(seller.getSellerId()).get();
            if(newSeller == null)
                throw new NullPointerException("Seller Not Found");
            newSeller.setSellerEmail(seller.getSellerEmail());
            newSeller.setSellerName(seller.getSellerName());
            newSeller.setSellerPassword(seller.getSellerPassword());
            newSeller.setSellerPic(seller.getSellerPic());
            newSeller.setSellerPhone(seller.getSellerPhone());
            newSeller.setSellerAddress(seller.getSellerAddress());
            Seller updatedSeller=sellerRepository.save(newSeller);

            response.put("UpdatedSeller",updatedSeller);
            response.put("Message","Updated Seller Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteSeller(Seller seller) {
        Map<String, Object>response=new HashMap<>();
        try{
            sellerRepository.deleteById(seller.getSellerId());
            response.put("Message","Deleted Seller Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
