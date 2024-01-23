package com.onestop.OneStopShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestop.OneStopShopping.model.Orders;
import com.onestop.OneStopShopping.repository.OrderService;

//OrderController.java
@RestController
@RequestMapping("/api/orders")
public class OrderController {

 @Autowired
 private OrderService orderService;

 @GetMapping("/user/{userId}")
 public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable Long userId) {
     List<Orders> orders = orderService.getOrdersByUserId(userId);
     return ResponseEntity.ok(orders);
 }

 @PostMapping("/create")
 public ResponseEntity<String> createOrder(@RequestBody Orders order) {
     orderService.saveOrder(order);
     return ResponseEntity.ok("Order created successfully");
 }
}