package com.example.FashionStore.Repository;

import com.example.FashionStore.Model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons,String> {
}
