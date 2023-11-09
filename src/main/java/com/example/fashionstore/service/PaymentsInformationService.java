package com.example.fashionstore.service;

import com.example.fashionstore.model.PaymentsInformation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentsInformationService {

    public List<PaymentsInformation> getPaymentInfoOfUser(Integer userId);

    public PaymentsInformation createPaymentsInformation(Integer userId,PaymentsInformation paymentsInformation);

    public PaymentsInformation updatePaymentsInformation(PaymentsInformation paymentsInformation);

    public String deletePaymentsInformation(PaymentsInformation paymentsInformation);

}
