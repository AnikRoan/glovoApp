package com.example.repository.jdbs;

import com.example.dto.Product;
import com.example.mapper.ProductMaper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductJdbcRepository {
    private final String SELECT_ALL_PRODUCTS = "SELECT * FROM product LIMIT 100";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    private final String INSERT_PRODUCT = "INSERT INTO product(name,cost) VALUE(?,?)";
    private final String UPDATE_PRODUCT = "UPDATE product SET name = ?, cost = ? WHERE id =?";
    private final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id = ? ";

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public Product getById(int id) {
        Product product = jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, new Object[]{id}, new ProductMaper());
        return product;
    }

    public List<Product> getAll() {
        List<Product> products = jdbcTemplate.query(SELECT_ALL_PRODUCTS, new ProductMaper());
        return products;
    }

    public void save(Product product) {
        jdbcTemplate.update(INSERT_PRODUCT, product.getName(), product.getCost());

    }

    public void update(Product product) {
        jdbcTemplate.update(UPDATE_PRODUCT, product.getName(), product.getCost(), product.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
    }

}
