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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrainingList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private TrainingType trainingType;
	@ManyToOne
	private Trainers trainers;
	@ManyToOne
	private Users employee;
	
	private Long trainerCost;
	
	private String status;
	
	private Date startDate;
	
	private Date endDate;
	
	private Boolean deleted;
	
	private String description;
	
	
	
	
}
