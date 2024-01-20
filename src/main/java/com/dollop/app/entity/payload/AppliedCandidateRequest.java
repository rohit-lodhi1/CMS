package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.ManageJobs;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppliedCandidateRequest {

	private Long id;

	private String candidateName;
	private String candidateEmail;
	
	private String message;
	
	private String originalName;
	
	private ManageJobs manageJobs;
	
	private Date applyDate;
	private String mobileNo;
	private String status="new";

}
