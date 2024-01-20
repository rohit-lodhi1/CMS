package com.dollop.app.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Expenses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private Date expenseDate; // Set the current date before persisting;
	
	private String description;
	
	private Double amount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="expenses_id_id")
	@JsonIgnoreProperties(value = {"expensesId"})
	private List<ExpensesFiles> expensesFiles;
	// colum text
	private String title;
	
//	@ManyToOne
//	private Projects projectId;
	
	@ManyToOne
	private Users userId;
	
	private Boolean deleted;
	
	private String status;
	
	private String paidBy;
	
//	  @PrePersist
//	    public void prePersist() {
//		  expenseDate  = new Date(System.currentTimeMillis()); // Set the current date before persisting
//	    }
}

