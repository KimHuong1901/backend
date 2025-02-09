package com.example.test.repository;

import com.example.test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findAllByDateBetween(Date startDate, Date endDate, Pageable pageable);
    Page<Order> findAllByProduct_NameContaining(String productName, Pageable pageable);
}
