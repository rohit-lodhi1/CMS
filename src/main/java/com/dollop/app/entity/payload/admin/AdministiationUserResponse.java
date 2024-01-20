package com.dollop.app.entity.payload.admin;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministiationUserResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName ;
	
	private	String lastName;
	
	private	String email;
	
	private String company;
	
	private Date createdAt;
	
	private String role;
	

}
