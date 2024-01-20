package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanySettings {
	@Id
	private Integer id;
	
	private String companyName;
	
	private String contactPerson;
	
	private String email;
	
	private String address;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String phoneNumber;
	
	private String mobileNumber;
	
	private String pinCode;
	
	private String faxNumber;
	
	private String websiteUrl;
	
}
