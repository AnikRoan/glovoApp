package com.example.resours;

import com.example.dto.Product;

import java.util.List;

public interface ServiceProductImpl {
    Product getProductByID(int id);
    List<Product> getAllProducts();

    void addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(int id);
}
