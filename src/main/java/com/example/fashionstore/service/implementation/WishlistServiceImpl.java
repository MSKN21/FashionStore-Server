package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.model.User;
import com.example.fashionstore.model.Wishlist;
import com.example.fashionstore.repository.ProductsRepository;
import com.example.fashionstore.repository.UserRepository;
import com.example.fashionstore.repository.WishlistRepository;
import com.example.fashionstore.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public List<Wishlist> getWishlistProductsByUser(Integer userId) {
        try {
            User user = userRepository.findById(userId).get();
            List<Wishlist> wishlistList = wishlistRepository.findByUser(user);
            return wishlistList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Boolean hasProductInWishlist(Integer userId, Integer productId) {
        try {
            User user = userRepository.findById(userId).get();
            Products product = productsRepository.findById(productId).get();
            List<Wishlist> wishlistList = wishlistRepository.findByUserAndProduct(user,product);
            if(wishlistList.isEmpty())
                return false;
            return true;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Wishlist getWishlistProductById(Integer wishlistId) {
        try {
            Wishlist wishlist = wishlistRepository.findById(wishlistId).get();
            return wishlist;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Wishlist addProductToWishlist(Integer userId, Integer productId) {
        try {
            User user = userRepository.findById(userId).get();
            Products product = productsRepository.findById(productId).get();
            Wishlist tempWishlist = new Wishlist();
            tempWishlist.setProducts(product);
            tempWishlist.setUser(user);
            Wishlist newWishlist = wishlistRepository.save(tempWishlist);
            return newWishlist;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteProductInWishlist(Wishlist wishlist) {
        try {
            wishlistRepository.deleteById(wishlist.getWishlistId());
            return "Successfully Deleted Product from Wishlist";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
