package com.example.test.service;

import com.example.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService  {
    List<Product> getAll();
    Page<Product> findByName(String name, Integer pageable);
}
