package com.dollop.app.entity.payload;


import com.dollop.app.entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerRequest {
	
    private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String description;
	
	private String status;
	
	private String email;
	private Designation role;
	
	private String phone;
}
