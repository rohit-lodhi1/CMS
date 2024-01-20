package com.dollop.app.entity.payload.employee;

import java.time.LocalDate;
import java.util.List;

import com.dollop.app.entity.Holidays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDashboardResponse {
	
	private Long totalProjects;
	
	private Long LeaveTaken;
	
	private Long totalPendingTask;
	
	private Long Remaining;
	
	private Long TotalTasks;
	
	private Long Remaining1;
	
	private Long Approved;
	
	
	private List<Holidays> upCommingHolidays;
	
	
	 
	   
}
