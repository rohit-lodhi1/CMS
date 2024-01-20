package com.dollop.app.service.employee;

import java.time.LocalDate;

import com.dollop.app.entity.payload.employee.EmployeeDashboardResponse;

public interface IEmployeeDashboardService {
	
	   public EmployeeDashboardResponse fetchDetails(String email,String status);
	   
	   
	   

}
