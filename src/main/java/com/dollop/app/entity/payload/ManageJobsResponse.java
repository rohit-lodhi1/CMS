package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJobsResponse {
	
	private Integer id;

	private Designation jobTitle;
	
	private Department department;
	

	
	private String jobLocation;
	
	private Integer  noOfVacancies;
	
	private String  experience;
	
	private Integer age;
	
	private String salaryFrom;
	private Integer noOfViews;
	private Integer totalAppliedCandidates;

	private Double salaryTo;
	
	private String jobType;
	
	private String status;
	
	private Date startDate;
	
	private Date expiredDate;
	
	
	private String description;
	
	private Boolean isDeletd;

}
