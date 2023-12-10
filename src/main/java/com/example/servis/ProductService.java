package com.example.servis;

import com.example.dto.Product;
import com.example.repository.jdbs.ProductJdbcRepository;
import com.example.resours.ServiceProductImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements ServiceProductImpl {

    public final ProductJdbcRepository productJdbcRepository;


    @Override
    public Product getProductByID(int id) {
        return productJdbcRepository.getById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productJdbcRepository.getAll();
    }

    @Override
    public void addProduct(Product product) {
        productJdbcRepository.save(product);

    }

    @Override
    public void updateProduct(Product product) {
        productJdbcRepository.update(product);

    }

    @Override
    public void removeProduct(int id) {
        productJdbcRepository.delete(id);

    }
}
