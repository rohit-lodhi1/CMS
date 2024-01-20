package com.dollop.app.entity;

import java.util.Date;

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
public class ExpensesFiles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String originalName;
	
	private String description;
	
	private Double fileSize; 
	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="expenses_id_id")
	private Expenses expensesId;
	
	
	private String fileName;
	
	 
	private Boolean deleted;
	

}
