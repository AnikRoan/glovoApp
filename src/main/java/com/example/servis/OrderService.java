package com.example.servis;

import com.example.dto.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class OrderService implements Servisimpl {
    List<Order> orders = new ArrayList<>();


    @Override
    public Order getOrderByID(int id) {
        return orders.stream()
                .filter(order -> Objects.equals(id, order.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);

    }

    @Override
    public void updateOrder(int id, Order newOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.set(i,newOrder);
            }
        }


    }
    @Override
    public void removeOrder(int id) {
        orders.removeIf(order -> Objects.equals(id, order.getId()));

    }
}
