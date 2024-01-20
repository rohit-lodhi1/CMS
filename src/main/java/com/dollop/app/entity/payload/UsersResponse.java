package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.Set;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Designation;
import com.dollop.app.entity.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class UsersResponse {

	private Integer id;

	private String firstName;

	private String lastName;

	private Boolean isAdmin;

	private String email;
	@JsonIgnore
	private String password;

	private Set<UserRoles> userRoles;

	private PermissionsAccess access;

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

	private String stickyNote;

	private String skype;

	private Boolean enableWebNotification;

	private Boolean enableEmailNotification;

	private Date createdAt;

	private Boolean deleted;
	private Designation designation;

}
