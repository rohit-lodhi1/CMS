package com.dollop.app.entity.payload;

import java.util.Date;

import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FamilyInformationsRequest {
	
	private Integer id;
	
	private String name;
	
	private String relationship; 
	
	private Date dateOfBirth;
	
	private Boolean isDelete;

	
	private String phone;

}
