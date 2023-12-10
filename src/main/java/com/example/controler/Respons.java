package com.example.controler;

import lombok.Data;

import java.util.List;
@Data
public class Respons <D>{
    boolean isSuccessful;
    D data;
    List<String> mesages;
}
