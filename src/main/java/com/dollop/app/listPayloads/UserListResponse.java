package com.dollop.app.listPayloads;

import java.sql.Date;

import com.dollop.app.entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponse {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private String originalName="profileImage";

	
	private String profileName ="defaultUserImage.png";
	

	private Designation designation;
	private Date dob;

	private String jobTitle;
	private String phone;
	// colum text
	private String address;

	private String alternativePhone;

}
