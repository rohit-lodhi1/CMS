package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OverTimeresponse {

	private Integer id;

	private UsersResponse userId;

	private Date overTimeDate;

	private Double overTimeHours;
	private String overTimeType;

	private UsersResponse approvedBy;
	private String description;

	private Boolean isDeleted;
	private String status;

}
