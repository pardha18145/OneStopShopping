package com.onestop.OneStopShopping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onestop.OneStopShopping.model.UserDTO;
import com.onestop.OneStopShopping.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users findByUserId(Long id) {
		
		return userRepository.getById(id);
	}

	@Override
	public Users findByUsername(String username) {
	    return userRepository.findByUsername(username);
	}
	 
	@Override
	public List<Users> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	@Override
	public Users createUser(Users user) {
	
		return userRepository.save(user);
	}
	
	@Override
	public Users updateUser(Long id, Users user) {

	    Optional<Users> existingUserOptional = userRepository.findById(id);
	    if (existingUserOptional.isPresent()) {
	        Users existingUser = existingUserOptional.get();
	        // Update user properties as needed
	        existingUser.setUsername(user.getUsername());
	        existingUser.setPassword(user.getPassword());
	        existingUser.setRole(user.getRole());
	        return userRepository.save(existingUser);
	    } else {
	        return null;
	    }
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

}
