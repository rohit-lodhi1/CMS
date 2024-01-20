package com.dollop.app.entity.payload;

import java.util.Date;
import java.util.List;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientsResponse {
	private Integer id;

	private String companyName;
	//colum text
	private String address;

	private String city;

	private String state;

	private String zip;

	private String country;

	private Date createdDate;
	//colum text
	private String website;
	
	private String ClientGroups;
	
	private String phone;
	
	private String currencySymbol;
	//colum mtext
	private String starredBy;
	//colum text
	private String vatNumber;
	
	private String gstNumber;
	
	private String status;
	
	private String currency;
	
	private List<String> labels;
	
	private Boolean deleted;
	
	private Users owner;
	
	private String email;
	
	private Boolean disableOnlinePayment;


}
