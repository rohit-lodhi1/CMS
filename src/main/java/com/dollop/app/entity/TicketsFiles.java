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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TicketsFiles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String originalName;
	
	private String description;
	
	private Double fileSize; 
	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="tickets_id")
	@JsonIgnoreProperties(value = {"ticketsFiles"})
	private Tickets ticketsId;
	
	
	private String fileName;
	
	@ManyToOne
	@JsonIgnoreProperties(value= {"userRoles"})
	private Users uploadedBy;
	 
	private Boolean deleted;
	

}
