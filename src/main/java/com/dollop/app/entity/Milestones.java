
package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Milestones {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;

	@ManyToOne
	private Projects projectId;

	// colum text
	private String title;

	// colum text
	private String description;

	private Date dueDate;

	private Boolean deleted;

	
}