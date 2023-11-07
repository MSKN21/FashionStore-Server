package com.example.FashionStore.Repository;

import com.example.FashionStore.Model.ShippingInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInformationRepository extends JpaRepository<ShippingInformation,Integer> {
}
