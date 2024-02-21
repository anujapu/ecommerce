package com.example.ecommercebackend.repo;

import com.example.ecommercebackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutRepository extends JpaRepository<Product,Long> {
}
