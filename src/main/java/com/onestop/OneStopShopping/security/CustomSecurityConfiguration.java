package com.onestop.OneStopShopping.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class CustomSecurityConfiguration {

	@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("pardhu").password("pardhu").build();
		UserDetails user2 = User.withDefaultPasswordEncoder().username("manoj").password("manoj").build();
		UserDetails user3 = User.withDefaultPasswordEncoder().username("chandra").password("chandra").build();
		
		return new InMemoryUserDetailsManager(user1,user2,user3);
	}
	
	
	@Bean
	DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.authorizeHttpRequests(
				authorize -> {
					authorize.requestMatchers("/user/{userId}","/api/orders/all","/{orderId}",
							"/update/{orderId}","/delete/{orderId}","/user/{userId}/totalAmount").authenticated();
					authorize.requestMatchers("/create").permitAll();
				}
				).formLogin(Customizer.withDefaults()).build();
	}
}
