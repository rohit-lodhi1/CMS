package com.dollop.app.entity;

import java.sql.Date;

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
public class Termination {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	@OneToOne
	private Users employee;
	
	@OneToOne
	private TerminationType terminationType;
	
	private String Department;
	
	private Date terminationDate;
	
	private Date noticeDate;
	
	private String Reason;
	
	private Boolean isDelete;

}
