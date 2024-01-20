package com.dollop.app.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ManageJobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	@ManyToOne
	private Designation jobTitle;

	@ManyToOne
	private Department department;

	private String jobLocation;

	private Integer noOfVacancies=0;

	private String experience;

	private Integer age;
	private Integer noOfViews=0;
	private Integer totalAppliedCandidates=0;

	private Double salaryFrom;

	private Double salaryTo;

	private String jobType;

	private String status;

	private Date startDate;

	private Date expiredDate;

	private String description;

	private Boolean isDeletd;
	


}
