package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverTimeRequest {

	private Integer id;

	private Integer userId;

	private Date overTimeDate;

	private Double overTimeHours;
	private String overTimeType;
	
	private Integer approvedBy;
	private String description;
	
	private Boolean isDeleted=false;
	private String status;
}
