package com.example.FashionStore.Repository;

import com.example.FashionStore.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products,String> {
}
