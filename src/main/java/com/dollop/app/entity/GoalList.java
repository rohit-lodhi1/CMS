package com.dollop.app.entity;

import java.sql.Date;

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
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class GoalList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String subject;

	private String targetAchievement;

	private Date startDate;

	private Date endDate;

	private Double progress;
	private Boolean isDelete = false;

	private String description;

	private String status;
	@ManyToOne
	@JoinColumn(name = "goal_type_id")

	private GoalType goalType;
}
