package com.example.resours;

import com.example.dto.Order;

import java.util.List;

public interface ServiceOrderImpl {

     Order getOrderByID(int id);
     List<Order> getAllOrders();

     void addOrder(Order order);
     void updateOrder(Order order);
     void removeOrder(int id);



}
