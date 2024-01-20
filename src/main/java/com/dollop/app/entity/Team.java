package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// colum text
	private String title;
	// colum mtext
	private String members;
	
	private Boolean deleted;
}
