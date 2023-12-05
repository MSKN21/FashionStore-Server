package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Orders;
import com.example.fashionstore.model.ShippingInformation;
import com.example.fashionstore.repository.OrdersRepository;
import com.example.fashionstore.repository.ShippingInformationRepository;
import com.example.fashionstore.service.ShippingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingInformationServiceImpl implements ShippingInformationService {

    @Autowired
    private ShippingInformationRepository shippingInformationRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<ShippingInformation> getShippingInformationOfOrder(Integer orderId) {
        try{
            Orders order=ordersRepository.findById(orderId).get();
            List<ShippingInformation>shippingInformationList=shippingInformationRepository.findByOrder(order);
            return shippingInformationList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ShippingInformation getShippingInformationById(Integer shippingId) {
        try{
            ShippingInformation shippingInformationList=shippingInformationRepository.findById(shippingId).get();
            return shippingInformationList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ShippingInformation createShippingInformation(Integer orderId,ShippingInformation shippingInformation) {
        try {
            Orders order=ordersRepository.findById(orderId).get();
            ShippingInformation tempShippingInformation = new ShippingInformation();
            tempShippingInformation.setAddress(shippingInformation.getAddress());
            tempShippingInformation.setCity(shippingInformation.getCity());
            tempShippingInformation.setCountry(shippingInformation.getCountry());
            tempShippingInformation.setPostalCode(shippingInformation.getPostalCode());
            tempShippingInformation.setAddress(shippingInformation.getAddress());
            tempShippingInformation.setOrders(order);
            ShippingInformation newShippingInformation = shippingInformationRepository.save(tempShippingInformation);
            return newShippingInformation;

        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public ShippingInformation updateShippingInformation(ShippingInformation shippingInformation) {
        try {
            ShippingInformation tempShippingInformation = new ShippingInformation();
            tempShippingInformation.setAddress(shippingInformation.getAddress());
            tempShippingInformation.setCity(shippingInformation.getCity());
            tempShippingInformation.setCountry(shippingInformation.getCountry());
            tempShippingInformation.setPostalCode(shippingInformation.getPostalCode());
            tempShippingInformation.setAddress(shippingInformation.getAddress());
            ShippingInformation updatedShippingInformation = shippingInformationRepository.save(tempShippingInformation);
            return updatedShippingInformation;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteShippingInformation(ShippingInformation shippingInformation) {
        try {
            shippingInformationRepository.deleteById(shippingInformation.getShippingId());
            return "Deleted Shipping Information Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
