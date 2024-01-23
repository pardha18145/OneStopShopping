package com.onestop.OneStopShopping.repository;

import java.util.List;

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
}