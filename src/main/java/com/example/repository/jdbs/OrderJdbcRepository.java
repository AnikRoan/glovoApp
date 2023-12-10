package com.example.repository.jdbs;

import com.example.dto.Order;
import com.example.dto.Product;
import com.example.mapper.OrderMaper;
import com.example.mapper.ProductMaper;
import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@RequiredArgsConstructor
public class OrderJdbcRepository {
    private final String UPDATE_ORDER = "UPDATE orders SET date = ? WHERE id = ?";
    private final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";
    private final String INSERT_ORDER = "INSERT INTO orders(date) VALUES (?)";


    private final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id=?";
    private final String SELECT_ALL = "SELECT * FROM orders";
    private final String SELECT_PRODUCT = "SELECT * FROM order_product " +
            "JOIN product ON order_product.product_id = product.id " +
            "WHERE order_product.order_id = ?";
    private final String UPDATE_ORDER_COST = "UPDATE orders " +
            "SET cost = (\n" +
            "    SELECT SUM(product.cost)\n" +
            "    FROM product\n" +
            "             JOIN order_product ON product.id = order_product.product_id\n" +
            "    WHERE order_product.order_id = orders.id\n" +
            ")\n" +
            "WHERE id = ?";



    private final JdbcTemplate jdbcTemplate;

    public Order getById(int id) {
        jdbcTemplate.update(UPDATE_ORDER_COST, id);

        Order result = jdbcTemplate.queryForObject(
                SELECT_ORDER_BY_ID, new Object[]{id},
                new OrderMaper()
        );

        List<Product> products = jdbcTemplate.query(SELECT_PRODUCT, new Object[]{id}, new ProductMaper());
        result.setProducts(products);

        return result;
    }


    public List<Order> getAll() {
        List<Order> result = jdbcTemplate.query(SELECT_ALL, new OrderMaper());
        for (Order order : result) {
            int orderId = order.getId();
            List<Product> products = jdbcTemplate.query(SELECT_PRODUCT, new Object[]{orderId}, new ProductMaper());
            order.setProducts(products);
        }
        return result;
    }


    public void save(Order dto) {

        jdbcTemplate.update(INSERT_ORDER, dto.getDate());

    }


    public void update(Order order) {

        jdbcTemplate.update(UPDATE_ORDER, order.getDate(), order.getId());

    }


    public void delete(int id) {
        jdbcTemplate.update(DELETE_ORDER, id);

    }


}
