package com.example.test.controller;

import com.example.test.model.Order;
import com.example.test.service.IOrderService;
import com.example.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<Page<Order>> getAllOrders(@RequestParam(defaultValue = "") Date date) {
        return new ResponseEntity<>(orderService.findByDate(date, 0), HttpStatus.OK);
    }
    @GetMapping("/search_product")
    public ResponseEntity<Page<Order>> searchByProducts(@RequestParam(defaultValue = "") String productName) {
        return new ResponseEntity<>(orderService.findByProductName(productName, 0), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> detailBlog(@PathVariable ("id") int id) {
        if(orderService.findById(id) == null ) {
            throw new NoSuchElementException("Không tìm thấy đơn hàng");
        }
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    orderService.addNew(order);
    return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") int id, @RequestBody Order orderDetails) {
        Order existingOrder = orderService.findById(id);
        if (existingOrder == null) {
            throw new NoSuchElementException("Không tìm thấy đơn hàng");
        }
        orderService.update(id, orderDetails);
        return new ResponseEntity<>(existingOrder, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
        Order existingOrder = orderService.findById(id);
        if (existingOrder == null) {
            throw new NoSuchElementException("Không tìm thấy đơn hàng");
        }
        orderService.deleteById(id);
        return new ResponseEntity<>("Xóa đơn hàng thành công", HttpStatus.OK);
    }

}
