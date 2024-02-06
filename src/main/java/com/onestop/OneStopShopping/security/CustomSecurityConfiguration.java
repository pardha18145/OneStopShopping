package com.onestop.OneStopShopping.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import com.onestop.OneStopShopping.repository.UserServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class CustomSecurityConfiguration {
	
    @Autowired
    private Environment environment;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.csrf().disable().authorizeHttpRequests(
				authorize -> {
					authorize.requestMatchers("/user/{userId}/totalAmount","/api/orders/all","/api/orders/{orderId}","/api/users/all","/api/users/id/{userId}").authenticated();
					authorize.requestMatchers("/create","/update/{orderId}","/delete/{orderId}").permitAll();
				}
				).formLogin(Customizer.withDefaults()).build();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("pardhu")
				.password(encoder.encode("pardhu"))
				.roles("admin")
				.build();
		
		UserDetails customer = User.withUsername("manoj")
				.password(encoder.encode("manoj"))
				.roles("customer")
				.build();
		return new InMemoryUserDetailsManager(admin,customer);
		
		//return new UserServiceImpl();
		
	}

}



