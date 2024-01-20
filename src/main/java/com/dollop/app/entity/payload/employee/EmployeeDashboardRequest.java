package com.dollop.app.entity.payload.employee;

import java.time.LocalDate;

import com.dollop.app.entity.payload.admin.AdminDashBoardResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDashboardRequest {
	 private Long totalProjects;
	   private Long LeaveTaken;
	   private Long totalPendingTask;
	   private Long Remaining;
	   private Long Remaining1;
	   private Long TotalTasks;
	   private Long Approved;
	   
	   private LocalDate upcmingHoliday;
}
