package com.example.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Số lượng không được để trống")
    private int quantity;
    @NotNull(message = "Ngày bắt đầu không được để trống")
    @Future(message = "Thời gian bắt đầu phải lớn hơn thời gian hiện tại")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name="id_product", referencedColumnName = "id")
    private Product product;
}
