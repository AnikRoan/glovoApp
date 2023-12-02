package com.example.noname;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
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
