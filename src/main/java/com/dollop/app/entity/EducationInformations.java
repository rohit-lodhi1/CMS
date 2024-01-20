package com.dollop.app.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class EducationInformations {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private String institution;
	
	private String subject;
	
	private Date startingDate;
	
	private Boolean isDelete;
	
	private Date completeDate;
	

	private String degree;
	private String grade;
	
	  @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonIgnoreProperties(value={"educationInformations"})
	    private Users user;


}
