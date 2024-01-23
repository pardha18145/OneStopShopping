package com.onestop.OneStopShopping.repository;

import java.util.List;

import com.onestop.OneStopShopping.model.Orders;

//OrderService.java
public interface OrderService {
 List<Orders> getOrdersByUserId(Long userId);
 void saveOrder(Orders order);
}