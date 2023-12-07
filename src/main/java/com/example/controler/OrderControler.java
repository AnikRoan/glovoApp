package com.example.controler;

import com.example.dto.Order;
import com.example.servis.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderControler {
    private final OrderService orderService;


    public OrderControler(OrderService orderService) {
        this.orderService = orderService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Integer id) {
        return this.orderService.getOrderByID(id);
    }

    @PostMapping("/update")
    public void saveOrder(@RequestBody Order order) {
        this.orderService.updateOrder(order);

    }
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.addOrder(order);


        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delitOrder(@PathVariable int id) {
        this.orderService.removeOrder(id);

    }
}