package com.example.fashionstore.repository;

import com.example.fashionstore.model.PaymentsInformation;
import com.example.fashionstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsInformationRepository extends JpaRepository<PaymentsInformation,Integer> {
    public List<PaymentsInformation> findByUser(User user);
}
