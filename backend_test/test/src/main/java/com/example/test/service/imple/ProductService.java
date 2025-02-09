package com.example.test.service.imple;

import com.example.test.model.Product;
import com.example.test.repository.ProductRepository;
import com.example.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    @Override
    public Page<Product> findByName(String name, Integer pageable) {
        return productRepository.findAllByNameContainingIgnoreCase(name, PageRequest.of(pageable, 5));
    }
}
