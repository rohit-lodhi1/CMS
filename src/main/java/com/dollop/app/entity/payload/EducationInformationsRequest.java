package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.EducationInformations;
import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class EducationInformationsRequest {
private Integer id;
	
	private String institution;
	
	private String subject;
	
	private Date startingDate;
	
	private Boolean isDelete;
	
	private Date completeDate;
	
	private String degree;
	private String grade;
	
	


}
