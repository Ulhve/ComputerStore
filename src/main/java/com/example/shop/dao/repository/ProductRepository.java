package com.example.shop.dao.repository;

import com.example.shop.dao.ProductType;
import com.example.shop.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByType(ProductType type);
}
