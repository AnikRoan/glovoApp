package com.example.resours;

import lombok.Data;

import java.util.List;
@Data
public class ApiResponse<D>{
    boolean isSuccessful;
    D data;
    String mesage;
}
