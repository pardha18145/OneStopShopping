package com.onestop.OneStopShopping.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onestop.OneStopShopping.model.Orders;
import com.onestop.OneStopShopping.model.OrdersDTO;
import com.onestop.OneStopShopping.repository.OrderService;

//OrderController.java
@RestController
@RequestMapping("/api/orders")
public class OrderController {

 @Autowired
 private OrderService orderService;

 @PreAuthorize("hasRole('customer')")
 @GetMapping("/user/{userId}")
 public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable Long userId) {
     List<Orders> orders = orderService.getOrdersByUserId(userId);
     return ResponseEntity.ok(orders);
 }
 
 @PreAuthorize("hasRole('admin')")
 @GetMapping("/all")
 public ResponseEntity<List<Orders>> getAllOrders() {
	 System.out.println("getting all orders");
     List<Orders> orders = orderService.getAllOrders();
     return ResponseEntity.ok(orders);
 }

 @PreAuthorize("hasRole('admin')")
 @PostMapping("/create")
 public ResponseEntity<String> createOrder(@RequestBody Orders order) {
     orderService.saveOrder(order);
     return ResponseEntity.ok("Order created successfully");
 }
 
 @PreAuthorize("hasRole('customer')")
 @GetMapping("/{orderId}")
 public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
     Orders order = orderService.getOrderById(orderId);
     if (order != null) {
         return ResponseEntity.ok(order);
     } else {
         return ResponseEntity.notFound().build();
     }
 }
 
 @PutMapping("/update/{orderId}")
 public ResponseEntity<String> updateOrder(@PathVariable Long orderId, @RequestBody Orders updatedOrder) {
     if (orderService.updateOrder(orderId, updatedOrder)) {
         return ResponseEntity.ok("Order updated successfully");
     } else {
         return ResponseEntity.notFound().build();
     }
 }
 
 @DeleteMapping("/delete/{orderId}")
 public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
     if (orderService.deleteOrder(orderId)) {
         return ResponseEntity.ok("Order deleted successfully");
     } else {
         return ResponseEntity.notFound().build();
     }
 }


 @GetMapping("/dateRange")
 public ResponseEntity<List<Orders>> getOrdersByDateRange(
         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
     List<Orders> orders = orderService.getOrdersByDateRange(startDate, endDate);
     return ResponseEntity.ok(orders);
 }

 @GetMapping("/user/{userId}/totalAmount")
 public ResponseEntity<BigDecimal> calculateTotalAmountByUserId(@PathVariable Long userId) {
     BigDecimal totalAmount = orderService.calculateTotalAmountByUserId(userId);
     return ResponseEntity.ok(totalAmount);
 }


}