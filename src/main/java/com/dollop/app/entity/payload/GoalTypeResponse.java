package com.dollop.app.entity.payload;

import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.GoalList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalTypeResponse {

	private Integer id;
	
	private String goalType;
	private String description;

	private List<GoalList> goalLists;
	private String status;

	private Boolean isDelete;

	
}
