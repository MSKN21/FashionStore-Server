package com.example.fashionstore.service;

import com.example.fashionstore.model.Coupons;

import java.util.List;

public interface CouponsService {
    public List<Coupons> getCoupons();

    public Coupons getCouponById(Integer couponsId);

    public Coupons createCoupon(Coupons coupons);

    public Coupons updateCoupon(Coupons coupons);

    public String deleteCoupon(Coupons coupons);
}
