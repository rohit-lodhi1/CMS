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

public class PersonalInformations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private String passportNo;

	private Date passportExpiryDate;
	
	private String 	nationality;

	private String 	tel;
	
	private String 	religion;
	
	private String 	maritalstatus;
	
	private String 	employmentOfSpouse;
	
	private Integer 	noOfChildren;
	
	
	private Boolean isDelete;
	
	@OneToOne
	private Users user;
	
	
	
	
	

}
