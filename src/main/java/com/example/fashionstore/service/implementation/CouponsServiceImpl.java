package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Coupons;
import com.example.fashionstore.repository.CouponsRepository;
import com.example.fashionstore.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponsServiceImpl implements CouponsService {

    @Autowired
    private CouponsRepository couponsRepository;

    @Override
    public List<Coupons> getCoupons() {
        try {
            List<Coupons>couponsList = couponsRepository.findAll();
            return couponsList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Coupons getCouponById(Integer couponsId) {
        try {
            Coupons coupons = couponsRepository.findById(couponsId).get();
            return coupons;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Coupons createCoupon(Coupons coupons) {
        try {
            Coupons newCoupons = couponsRepository.save(coupons);
            return newCoupons;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public Coupons updateCoupon(Coupons coupons) {
        try {
            Coupons tempCoupons = couponsRepository.findById(coupons.getCouponId()).get();
            tempCoupons.setCode(coupons.getCode());
            tempCoupons.setDiscountPercentage(coupons.getDiscountPercentage());
            tempCoupons.setEndDate(coupons.getEndDate());
            tempCoupons.setEndDate(coupons.getEndDate());
            Coupons updatedCoupons = couponsRepository.save(tempCoupons);
            return updatedCoupons;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteCoupon(Coupons coupons) {
        try {
            couponsRepository.deleteById(coupons.getCouponId());
            return "Deleted Coupon Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
