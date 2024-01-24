package com.onestop.OneStopShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestop.OneStopShopping.model.Users;
import com.onestop.OneStopShopping.repository.UserService;

//UserController.java
@RestController
@RequestMapping("/api/users")
public class UserController {

 @Autowired
 private UserService userService;

 @GetMapping("/{username}")
 @PreAuthorize("hasRole('USER')")
 public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
     Users user = userService.findByUsername(username);
     return ResponseEntity.ok(user);
 }
 
 @GetMapping("/all")
 @PreAuthorize("hasRole('USER')")
 public ResponseEntity<List<Users>> getAllUsers() {
     List<Users> users = userService.getAllUsers();
     return ResponseEntity.ok(users);
 }

 @PostMapping("/create")
 @PreAuthorize("hasRole('ADMIN')")
 public ResponseEntity<Users> createUser(@RequestBody Users user) {
     Users createdUser = userService.createUser(user);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
 }

 @PutMapping("/{id}")
 @PreAuthorize("hasRole('ADMIN')")
 public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
     Users updatedUser = userService.updateUser(id, user);
     if (updatedUser != null) {
         return ResponseEntity.ok(updatedUser);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/{id}")
 @PreAuthorize("hasRole('USER')")
 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
     userService.deleteUser(id);
     return ResponseEntity.noContent().build();
 }
 
}