package com.onestop.OneStopShopping.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestop.OneStopShopping.model.Orders;

//OrderServiceImpl.java
@Service
public class OrderServiceImpl implements OrderService {

 @Autowired
 private OrderRepository orderRepository;

 @Override
 public List<Orders> getOrdersByUserId(Long userId) {
     return orderRepository.findByUserId(userId);
 }

 @Override
 public void saveOrder(Orders order) {
     orderRepository.save(order);
 }

 @Override
 public Orders getOrderById(Long orderId) {
     Optional<Orders> optionalOrder = orderRepository.findById(orderId);
     return optionalOrder.orElse(null);
 }

 @Override
 public boolean updateOrder(Long orderId, Orders updatedOrder) {
     Optional<Orders> optionalOrder = orderRepository.findById(orderId);
     if (optionalOrder.isPresent()) {
         Orders existingOrder = optionalOrder.get();
         // Update order properties as needed
         existingOrder.setOrderDate(updatedOrder.getOrderDate());
         existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
         existingOrder.setId(updatedOrder.getId());
         orderRepository.save(existingOrder);
         return true;
     } else {
         return false; // Order with the specified ID not found
     }
 }

 @Override
 public boolean deleteOrder(Long orderId) {
     if (orderRepository.existsById(orderId)) {
         orderRepository.deleteById(orderId);
         return true;
     } else {
         return false; // Order with the specified ID not found
     }
 }

@Override
public List<Orders> getAllOrders() {
    return orderRepository.findAll();
}

@Override
public List<Orders> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
    // Assuming your Orders entity has a 'orderDate' field
    return orderRepository.findByOrderDateBetween(startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX));
}

@Override
public BigDecimal calculateTotalAmountByUserId(Long userId) {
    List<Orders> userOrders = orderRepository.findByUserId(userId);
    BigDecimal totalAmount = userOrders.stream()
            .map(Orders::getTotalAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    return totalAmount;
}
}