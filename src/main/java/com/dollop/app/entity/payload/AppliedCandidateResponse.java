package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.ManageJobs;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppliedCandidateResponse {
	private Long id;

	private String candidateName;
	private String candidateEmail;

	private String message;

	private String originalName;

	private ManageJobs manageJobs;

	private Date applyDate;
	private String mobileNo;
	private String status;

}
