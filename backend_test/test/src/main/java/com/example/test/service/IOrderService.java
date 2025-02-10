package com.example.test.service;

import com.example.test.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;

public interface IOrderService extends IBaseService<Order>{
    Page<Order> findByDate(LocalDate date, Integer pageable);
    Page<Order> findByProductName(String productName, Integer pageable);
}
