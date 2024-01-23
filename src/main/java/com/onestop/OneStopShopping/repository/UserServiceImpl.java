package com.onestop.OneStopShopping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestop.OneStopShopping.model.Users;

//UserServiceImpl.java
@Service
public class UserServiceImpl implements UserService {

 @Autowired
 private UserRepository userRepository;

 @Override
 public Users findByUsername(String username) {
     return userRepository.findByUsername(username);
 }

@Override
public List<Users> getAllUsers() {
	// TODO Auto-generated method stub
	return userRepository.findAll();
}

@Override
public Users createUser(Users user) {
	// TODO Auto-generated method stub
	return userRepository.save(user);
}

@Override
public Users updateUser(Long id, Users user) {
	// TODO Auto-generated method stub
	// Implement your logic for updating an existing user
    // Ensure the user with the specified ID exists before updating
    Optional<Users> existingUserOptional = userRepository.findById(id);
    if (existingUserOptional.isPresent()) {
        Users existingUser = existingUserOptional.get();
        // Update user properties as needed
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    } else {
        return null; // User with the specified ID not found
    }
}

@Override
public void deleteUser(Long id) {
	userRepository.deleteById(id);
	
}
}
