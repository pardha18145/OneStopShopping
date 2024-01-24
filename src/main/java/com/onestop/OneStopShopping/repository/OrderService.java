package com.onestop.OneStopShopping.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.onestop.OneStopShopping.model.Orders;

//OrderService.java
public interface OrderService {
 List<Orders> getOrdersByUserId(Long userId);
 void saveOrder(Orders order);
Orders getOrderById(Long orderId);
boolean updateOrder(Long orderId, Orders updatedOrder);
boolean deleteOrder(Long orderId);
List<Orders> getAllOrders();
List<Orders> getOrdersByDateRange(LocalDate startDate, LocalDate endDate);
BigDecimal calculateTotalAmountByUserId(Long userId);
}