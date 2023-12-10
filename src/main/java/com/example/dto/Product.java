package com.example.dto;

import jakarta.persistence.*;
import lombok.*;



@Data
@EqualsAndHashCode
@AllArgsConstructor

@ToString
@Setter
@Entity


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;


    public Product() {

    }
}
