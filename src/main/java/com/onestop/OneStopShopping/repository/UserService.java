package com.onestop.OneStopShopping.repository;

import java.util.List;

import com.onestop.OneStopShopping.model.Users;

public interface UserService {
    Users findByUsername(String username);

	List<Users> getAllUsers();

	Users createUser(Users user);

	Users updateUser(Long id, Users user);

	void deleteUser(Long id);
	
	Users findByUserId(Long id);
}