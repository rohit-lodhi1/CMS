package com.dollop.app.entity;

import java.util.Date;

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


public class FamilyInformations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  	
	private Integer id;
	
	private String name;
	
	private String relationship; 
	
	private Date dateOfBirth;
	
	private Boolean isDelete;

	
	private String phone;


	  @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonIgnoreProperties(value={"familyInformations"})
	    private Users user;

}
