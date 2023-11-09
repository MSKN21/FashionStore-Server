package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.PaymentsInformation;
import com.example.fashionstore.model.User;
import com.example.fashionstore.repository.PaymentsInformationRepository;
import com.example.fashionstore.repository.UserRepository;
import com.example.fashionstore.service.PaymentsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentsInformationServiceImpl implements PaymentsInformationService {

    @Autowired
    private PaymentsInformationRepository paymentsInformationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PaymentsInformation> getPaymentInfoOfUser(Integer userId) {
        try{
            User user=userRepository.findById(userId).get();
            List<PaymentsInformation>paymentsInformationList=paymentsInformationRepository.findByUser(user);
            return paymentsInformationList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public PaymentsInformation createPaymentsInformation(Integer userId,PaymentsInformation paymentsInformation) {
        try{
            User user=userRepository.findById(userId).get();
            PaymentsInformation tempPaymentsInformation=new PaymentsInformation();
            tempPaymentsInformation.setCardNumber(paymentsInformation.getCardNumber());
            tempPaymentsInformation.setCvv(paymentsInformation.getCvv());
            tempPaymentsInformation.setExpiryDate(paymentsInformation.getExpiryDate());
            tempPaymentsInformation.setUser(user);
            PaymentsInformation newPaymentsInformation = paymentsInformationRepository.save(tempPaymentsInformation);
            return newPaymentsInformation;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public PaymentsInformation updatePaymentsInformation(PaymentsInformation paymentsInformation) {
        try{
            PaymentsInformation newPaymentsInformation = paymentsInformationRepository.findById(paymentsInformation.getPaymentId()).get();
            newPaymentsInformation.setCardNumber(paymentsInformation.getCardNumber());
            newPaymentsInformation.setCvv(paymentsInformation.getCvv());
            newPaymentsInformation.setExpiryDate(paymentsInformation.getExpiryDate());
            PaymentsInformation updatedPaymentsInformation = paymentsInformationRepository.save(newPaymentsInformation);
            return updatedPaymentsInformation;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deletePaymentsInformation(PaymentsInformation paymentsInformation) {
        try{
            paymentsInformationRepository.deleteById(paymentsInformation.getPaymentId());
            return "Deleted Payment Information Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
