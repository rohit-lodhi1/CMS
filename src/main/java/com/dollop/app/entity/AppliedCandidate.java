package com.dollop.app.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppliedCandidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;      

	private String candidateName;
	private String candidateEmail;
	
	private String message;
	
	private String originalName;
	private String fileName;
	
	@ManyToOne
	private ManageJobs manageJobs;
	
	private Date applyDate;
	private String mobileNo;
	private String status;

}
