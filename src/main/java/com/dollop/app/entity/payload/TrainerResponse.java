package com.dollop.app.entity.payload;

import com.dollop.app.entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerResponse {
	
    private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String description;
	
	private String status;
	private Designation role;
	
	private String email;
	
	private String phone;
}
