package com.dollop.app.entity;


import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeSheets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;

	private String assignedHours;
	private String workedHours;
	private String hours;

	private LocalDate timeSheetDate;

	public String description;

	@ManyToOne
    private Users   user;


	@ManyToOne
	private Projects projectId;

	@ManyToOne
	private Tasks taskId;
	
	private Boolean deleted;

}
