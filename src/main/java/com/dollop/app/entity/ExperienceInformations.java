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


public class ExperienceInformations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private String companyName;
	
	private String location;
	
	private String jobPosition;
	
	private Date periodFrom;
	
	private Boolean isDelete;
	
	private Date periodTo;
	
	  @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonIgnoreProperties(value={"experienceInformations"})
	    private Users user;

	
	
	

}
