package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveApplicationResponse {
private Integer id;
	
	private Date startDate;
	
	private Date endDate;
	
	private Double totalHours;
	
	private Double totalDays;

	private LeaveTypes leaveTypeId;

	private Users applicantId;

	
	private String reason;
	
	private Integer createdBy;
	
	private Users checkedBy;
	
	
	private Date createdAt; 
	
	
	private Date checkedAt; 
	//enum
	private String status; 
	
	private Boolean deleted;
}
