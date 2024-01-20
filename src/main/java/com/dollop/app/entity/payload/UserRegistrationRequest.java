package com.dollop.app.entity.payload;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    
	private Integer id;
	
	private String email;
	
	private String userName;
	
	private String password;
	
	private Boolean active;
	
	private LocalDateTime generatedTime;
	
	private String otp;
	
}
