package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private String title;
	// colum mtext
	private String descripton;
	
	private Date startDate;
	
	private Date endDate;
	
	private Date startTime;
	
	private Date endTime;
	
	private Integer createdBy;
	// colum mtext
	private String location;
	
	@ManyToOne
	private Clients clientId;
	// colum text
	
	private String labels;
	// colum mtext
	private String shareWith;
	
	private Boolean deleted;
	
	private String color;
}
