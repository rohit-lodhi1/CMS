package com.dollop.app.entity.payload;

import java.util.Date;
import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.Users;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonalInformationsResponse {

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
	
	
}
