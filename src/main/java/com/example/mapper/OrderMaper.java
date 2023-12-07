package com.example.mapper;

import com.example.dto.Order;
import com.example.dto.Product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class OrderMaper implements RowMapper<Order> {
   // private final JdbcTemplate jdbcTemplate = new JdbcTemplate();



    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setDate(rs.getDate("date").toLocalDate());
        order.setCost(rs.getDouble("cost"));


      //  List<Product> products = new ArrayList<>();

//        int orderId = order.getId();
//
//        // Используйте JdbcTemplate для выполнения запроса и получения всех продуктов для данного заказа
//        String productQuery = "SELECT * FROM order_product " +
//                "JOIN product ON order_product.product_id = product.id " +
//                "WHERE order_product.order_id = ?";
//        List<Product> products = jdbcTemplate.query(productQuery, new Object[]{orderId}, new ProductMaper());
//
//        order.setProducts(products);

//        do{
//            Product product = new Product();
//            product.setId(rs.getInt("product_id"));
//            product.setName(rs.getString("product_name"));
//            product.setCost(rs.getDouble("product_cost"));
//            products.add(product);
//        }while (rs.next()&&order.getId() == rs.getInt("order_id"));
//
//        order.setProducts(products);



        return order;
    }

}
