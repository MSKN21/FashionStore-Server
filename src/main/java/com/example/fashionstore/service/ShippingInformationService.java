package com.example.fashionstore.service;

import com.example.fashionstore.model.ShippingInformation;

import java.util.List;

public interface ShippingInformationService {

    List<ShippingInformation> getShippingInformationOfOrder(Integer orderId);

    public ShippingInformation getShippingInformationById(Integer shippingId);

    ShippingInformation createShippingInformation(Integer orderId, ShippingInformation shippingInformation);

    public ShippingInformation updateShippingInformation(ShippingInformation shippingInformation);

    public String deleteShippingInformation(ShippingInformation shippingInformation);
}
