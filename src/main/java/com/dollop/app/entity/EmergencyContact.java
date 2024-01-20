package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class EmergencyContact {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private String name;
	
	private String name1;
	
	private String relationship;
	
	private String relationship1;
	
	private String phone;
	
	private String phone1;
	
	private String phone2;
	
	private Boolean isDelete;
	
	private String Phone3;
	
	@OneToOne
	private Users user;
	
	
	
}
