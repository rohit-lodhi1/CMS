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
public class OverTime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Users userId;

	private Date overTimeDate;

	private Double overTimeHours;
	private String overTimeType;
	@ManyToOne
	private Users approvedBy;
	private String description;
	
	private Boolean isDeleted;
	private String status;

}
