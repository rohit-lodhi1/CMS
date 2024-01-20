package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectFiles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String originalName;
	
	private String description;
	
	private Double fileSize; 
	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="project_id_id")
	private Projects projectId;
	
	
	private String fileName;
	
	@ManyToOne
	private Users uploadedBy;
	 
	private Boolean deleted;
	
} 




 