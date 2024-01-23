package com.onestop.OneStopShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onestop.OneStopShopping.model.Orders;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUserId(Long userId);
}