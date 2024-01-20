package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectTime {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	
	private String note;
	
	private Boolean deleted;
	
	@OneToOne
	private Users userId;
	
	private Date endTime;
	
	private Date startTime;
	// enum
	private String status;
	
	@OneToOne
	private Projects projectId;
	
	@OneToOne
	private Tasks taskId;
}
