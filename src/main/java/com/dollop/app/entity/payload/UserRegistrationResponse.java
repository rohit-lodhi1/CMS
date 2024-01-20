  package com.dollop.app.entity.payload;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponse {
    
	private Integer id;
	
	private String email;
	
	private String password;
	
	private String userName;
	
	private Boolean active;
	
	private LocalDateTime generatedTime;
	
	private String otp;
	
}
