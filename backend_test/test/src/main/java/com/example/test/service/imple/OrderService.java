package com.example.test.service.imple;

import com.example.test.model.Order;
import com.example.test.repository.OrderRepository;
import com.example.test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Page<Order> findByDate(LocalDate date, Integer pageable) {
        return orderRepository.findAllByDateBetween(date, date, PageRequest.of(pageable, 5));
    }

    @Override
    public Page<Order> findByProductName(String productName, Integer pageable) {
        return orderRepository.findAllByProduct_NameContaining(productName, PageRequest.of(pageable, 5));
    }

    @Override
    public void addNew(Order order) {
        orderRepository.save(order);

    }

    @Override
    public boolean update(int id, Order order) {
        orderRepository.save(order);
        return true;
    }

    @Override
    public List getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public boolean deleteById(int id) {
       orderRepository.deleteById(id);
       return true;
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
