package com.example.servis;

import com.example.dto.Order;
import com.example.repository.jdbs.OrderJdbcRepository;
import com.example.resours.ServiceOrderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class OrderService implements ServiceOrderImpl {

    private final OrderJdbcRepository orderJdbcRepository;




    @Override
    public Order getOrderByID(int id) {
        return orderJdbcRepository.getById(id);

    }


    @Override
    public List<Order> getAllOrders() {
        return orderJdbcRepository.getAll();
    }

    @Override
    public void addOrder(Order order) {
      orderJdbcRepository.save(order);
    }

    @Override
    public void updateOrder(Order order) {
     orderJdbcRepository.update(order);
    }



    @Override
    public void removeOrder(int id) {
     orderJdbcRepository.delete(id);
    }
}
