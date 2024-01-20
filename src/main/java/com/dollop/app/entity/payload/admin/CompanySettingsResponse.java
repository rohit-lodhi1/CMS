package com.dollop.app.entity.payload.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanySettingsResponse {
	
    private Integer id;
	
	private String companyName;
	
	private String contactPerson;
	
	private String Email;
	
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
