package com.dollop.app.entity.payload.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AttendanceStaticsResponse {

	
	private String today;
	
	private String week;
	
	private String month;
	
	private String remaining;

	
	private String misPunched;
	
	private String dayHours;
	
	private String weekHours;
	
	private String monthHours;
	


}
