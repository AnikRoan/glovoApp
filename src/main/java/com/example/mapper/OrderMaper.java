package com.example.mapper;

import com.example.dto.Order;
import com.example.dto.Product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class OrderMaper implements RowMapper<Order> {




    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setDate(rs.getDate("date").toLocalDate());
        order.setCost(rs.getDouble("cost"));




        return order;
    }

}
