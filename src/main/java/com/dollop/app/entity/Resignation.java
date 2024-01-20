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
public class Resignation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

	@OneToOne
	private Users employee;
	 
	private String reason;
	
	private Boolean isDelete;
	
	private Date noticeDate;
	
	private Date resigning;
	
	private String department;
	

}
