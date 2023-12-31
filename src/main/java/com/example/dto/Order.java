package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@EqualsAndHashCode


public class Order {

    private int id;
    private LocalDate date;

    private double cost;
    private List<Product> products;


}
