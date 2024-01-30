package com.onestop.OneStopShopping.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_username", unique = true, nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;


    @ManyToOne
    @JoinColumn(name = "role_user_id")
    private UserRole userRole;

}
