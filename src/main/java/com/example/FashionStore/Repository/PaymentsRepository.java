package com.example.FashionStore.Repository;

import com.example.FashionStore.Model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments,String> {
}
