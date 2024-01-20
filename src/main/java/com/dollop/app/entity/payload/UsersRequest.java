package com.dollop.app.entity.payload;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsersRequest {
	
	private Integer id;

	private String firstName;

	private String lastName;


	private Boolean isAdmin;

	private String email;

	private String password;
	
private String originalName;
	
	private String profileName;

	private String status;

	private Date messageCheckedAt;

	private Clients clienId;

	private Date notificationCheckedAt;

	private Boolean isPrime;

	private String jobTitle;

	private Boolean disableLogin;

	private String note;

	private String alternativeAddress;

	private String phone;
	
	private String address;

	private String alternativePhone;

	private Date dob;

	private String ssn;

	private String gender;
	//colum mtext
	private String stickyNote;
	//colum text
	private String skype;

	private Boolean enableWebNotification;

	private Boolean enableEmailNotification;

	private Date createdAt;

	private Boolean deleted;
	private Designation designation;



}
