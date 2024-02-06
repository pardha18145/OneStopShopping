package com.onestop.OneStopShopping.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrdersDTO {
	
    private Long id;
    private Users user;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    
}
