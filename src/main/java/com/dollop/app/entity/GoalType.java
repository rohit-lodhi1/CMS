package com.dollop.app.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GoalType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String goalType;
	private String description;

	@OneToMany
	@JoinColumn(name = "goal_type_id")
	@JsonIgnore
	private List<GoalList> goalLists;
	private String status;

	private Boolean isDelete;

}
