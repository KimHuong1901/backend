package com.example.test.repository;

import com.example.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product>findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
