package com.example.controler;

import com.example.dto.Order;
import com.example.dto.Product;
import com.example.resours.ApiResponse;
import com.example.servis.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
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
    public ApiResponse<List<Order>> getAll() {
        ApiResponse<List<Order>> allOrders = new ApiResponse<>();
        List<Order> orders = orderService.getAllOrders();
        if (!CollectionUtils.isEmpty(orders)) {
            allOrders.setSuccessful(true);
            allOrders.setData(orders);
        } else {
            allOrders.setSuccessful(false);
            allOrders.setMesage("orders not found");
        }
        return allOrders;


    }


    @GetMapping("/{id}")
    public ApiResponse<Order> get(@PathVariable Integer id) {
        ApiResponse<Order> orderResponse = new ApiResponse<>();
        Order order = orderService.getOrderByID(id);
        if (order != null) {
            orderResponse.setSuccessful(true);
            orderResponse.setData(order);
        } else {
            orderResponse.setSuccessful(false);
            orderResponse.setMesage("order not found");
        }
        return orderResponse;
    }

    @PostMapping("/update")
    public ApiResponse<Order> saveOrder(@RequestBody Order order) {
        this.orderService.updateOrder(order);
        ApiResponse<Order> updateOrder = new ApiResponse<>();
        updateOrder.setSuccessful(true);
        updateOrder.setMesage("order updated successfully");
        updateOrder.setData(order);

        return updateOrder;


    }

    @PostMapping("/create")
    public ApiResponse<Order> createOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        ApiResponse<Order> newOrder = new ApiResponse<>();
        newOrder.setSuccessful(true);
        newOrder.setData(order);
        newOrder.setMesage("create order");

        return newOrder;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delitOrder(@PathVariable int id) {
        Order o = this.orderService.getOrderByID(id);
        ApiResponse<String> order = new ApiResponse<>();
        if (o != null) {
            this.orderService.removeOrder(id);
            order.setSuccessful(true);
            order.setMesage("order deleted");
        } else {
            order.setSuccessful(false);
            order.setMesage("order not found");
        }
        return order;


    }
}
