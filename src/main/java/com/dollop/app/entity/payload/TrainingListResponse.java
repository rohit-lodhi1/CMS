package com.dollop.app.entity.payload;

import java.util.Date;

import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.TrainingType;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingListResponse {
	
	private Integer id;
	private TrainingType trainingType;
	private Trainers trainers;
	private UsersRequest employee;
	
	private Long trainerCost;
	
	private String status;
	
	private Date startDate;
	
	private Date endDate;
	
	private Boolean deleted;
	
	private String description;
}
