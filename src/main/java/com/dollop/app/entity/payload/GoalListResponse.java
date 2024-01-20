package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.GoalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GoalListResponse {
private Integer id;
	
	private String subject;
	
	private String targetAchievement;
	
	private Date startDate;
	
	private Date endDate	;
	private Double progress;
	private String description;
	
	private Boolean isDelete;
	
	private String Status;

	private GoalType goalType;
}
