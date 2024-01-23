package com.onestop.OneStopShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onestop.OneStopShopping.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}