package com.dollop.app.entity.payload;

import java.util.Date;

import com.dollop.app.entity.FamilyInformations;
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

public class FamilyInformationsResponse {
	
	private Integer id;
	
	private String name;
	
	private String relationship; 
	
	private Boolean isDelete;

	private Date dateOfBirth;
	
	private String phone;


	  @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonIgnoreProperties(value={"familyInformations"})
	    private Users user;


}
