package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.ExpenseCategories;
import com.dollop.app.entity.ExpensesFiles;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExpensesRequest {
	private Integer id;

	private Date expenseDate;

	private String description;

	private Double amount;

	private List<ExpensesFiles> expensesFiles;
	// colum text
	private String title;

	private Users userId;

	private Boolean deleted;

	private String status;

	private String paidBy;
}
