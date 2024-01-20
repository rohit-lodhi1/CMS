package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExperienceInformationsResponse {
	
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
