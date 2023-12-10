package com.example.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Setter


public class Order {


    private int id;
    private double cost;
    private LocalDate date;

    private List<Product> products;


    public Order() {
        this.products = new ArrayList<>();

    }
}
