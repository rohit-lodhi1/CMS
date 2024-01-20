package com.dollop.app.entity.payload.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLeaveStatics {

	private Integer annualLeaves;
	
	private Integer medicalLeaves;
	
	private Integer otherLeaves;
	
	private Integer remainingLeaves;
	
}
