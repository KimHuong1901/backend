package com.example.test.repository;

import com.example.test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findAllByDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
    Page<Order> findAllByProduct_NameContaining(String productName, Pageable pageable);
}
