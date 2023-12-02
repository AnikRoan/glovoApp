package com.example.dto;

import lombok.*;



@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private double cost;


}
